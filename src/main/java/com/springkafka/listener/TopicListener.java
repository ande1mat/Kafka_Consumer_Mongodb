package com.springkafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@PropertySource("classpath:application.properties")
public class TopicListener {

    @Value("${topic-name}")


    @KafkaListener(
            id = "test",
            topics = "${topic-name}",
            groupId = "consumer-group",
            properties = {"bootstrap.server=localhost:9092"}
    )
    public void listen(String data) {
        System.out.println(data);
    }


}
