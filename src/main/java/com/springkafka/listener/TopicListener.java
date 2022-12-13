package com.springkafka.listener;

import com.springkafka.domain.ItemMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@PropertySource("classpath:application.properties")
public class TopicListener {

    @KafkaListener(
            id = "test",
            topics = "${topic-name}",
            containerFactory = "kafkaListener"
    )
    public void listen(ItemMessage item, Acknowledgment acknowledgment){

        System.out.println("Consumed Message :"+item);

        System.out.println(item.getItem_id());
        System.out.println(item.getBarcode());
        System.out.println(item.getType());
        System.out.println(item.getCountry());
        System.out.println(item.getDescription());

        /*if (isEmptyMessage(item)) {
            System.out.println("Empty message received from kafka.");
            acknowledgment.acknowledge();
            return;
        }*/

        //Commit the Offset and read the next kafka event
        acknowledgment.acknowledge();

        //Need to add error handling, need to set backoff strategy to limit retries
        //Need to commit the offset to move to the next record

    }
}
