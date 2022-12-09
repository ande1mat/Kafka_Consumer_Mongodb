package com.springkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {

    //@Autowired
    //private Environment environment;

    //String topicName = environment.getProperty("topic-name");
    //String bootstrapServer = environment.getProperty("bootstrap-servers");

    @KafkaListener(
            id = "test",
            topics = "retail-topic",
            groupId = "consumer-group",
            properties = {"bootstrap.server=localhost:9092"}
    )
    public void listen(String data) {
        System.out.println(data);
    }


}
