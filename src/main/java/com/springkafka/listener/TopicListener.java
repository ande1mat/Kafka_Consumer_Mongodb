package com.springkafka.listener;

import com.springkafka.domain.ItemMessage;
import com.springkafka.mapper.ItemMapper;
import com.springkafka.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@PropertySource("classpath:application.properties")
public class TopicListener {


    @Autowired
    private ConsumerService service;

    @Autowired
    public TopicListener(ConsumerService service) {
        this.service = service;
    }

    @KafkaListener(
            id = "test",
            topics = "${topic-name}",
            containerFactory = "kafkaListener"
    )
    public void listen(ItemMessage item, Acknowledgment acknowledgment){
        try {
            System.out.println("Consumed Message :"+item);
            //Map the ItemMessage to Item Domain adn Model objects then Save to MongoDB
            service.saveItem(ItemMapper.itemtoItemMessage(item));

            //Map the ItemMessage to Location Domain and Model objects then Save to MongoDB
            service.saveInventory(ItemMapper.itemtoInventoryMessage(item), ItemMapper.getItemIdMessage(item), ItemMapper.getItemTypeMessage(item));

            System.out.println ("Saved the Item and Inventory to MongoDB");
        } catch (Exception e) {
            System.out.println("Message consumption failed for message {}"+item);
            System.out.println(e);

            //Write the to the dead letter table collection in MongoDB if we can consume but hand some other error with the message processing
            service.saveDeadLetter(item.toString(), "Error processing consumed Message - " + e.toString());


        } finally {
            acknowledgment.acknowledge();
        }
    }
}
