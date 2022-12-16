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

        //System.out.println("Consumed Message :"+item);

        //String json = item.toString();
        try {
            System.out.println("Consumed Message :"+item);
            //Call my service calss to start doing stuff
            // Simulating an error case
            // throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Message consumption failed for message {}"+item);
            //String originalTopic = consumerRecord.topic();
            //ProducerRecord<String, String> record = new ProducerRecord<>(DLQ_TOPIC, json);
            //record.headers().add(ORIGINAL_TOPIC_HEADER_KEY, originalTopic.getBytes(UTF_8));
            //kafkaTemplate.send(record);
        } finally {
            acknowledgment.acknowledge();
        }


        //consumer.commitSync();

        /*if (isEmptyMessage(item)) {
            System.out.println("Empty message received from kafka.");
            acknowledgment.acknowledge();
            return;
        }*/

        //Commit the Offset and read the next kafka event
        //acknowledgment.acknowledge();

        //Need to add error handling, need to set backoff strategy to limit retries
        //Need to commit the offset to move to the next record

    }
}
