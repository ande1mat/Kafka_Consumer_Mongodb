package com.springkafka.config;

import com.springkafka.domain.ItemMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;


/* Running Local Host Kafka
Start zookeeper: bin/zookeeper-server-start.sh config/zookeeper.properties
Start Kafka Server: bin/kafka-server-start.sh config/server.properties
Create a Topic: bin/kafka-topics.sh --create --topic new-topic-name --bootstrap-server localhost:9092
Produce messages: bin/kafka-console-producer.sh --topic new-topic-name --bootstrap-server localhost:9092
Sample JSON: {"item_id":1, "barcode":"A123456789", "type":"movie", "description":"The Arrival of a Train", "country":"USA"}
*/

@EnableKafka
@Configuration
@PropertySource("classpath:application.properties")
public class KafkaConfig {

    @Value("${bootstrap-servers}")
    private String bootstrapserver;

    @Value("${group-id}")
    private String groupid;

    @Bean
    public ConsumerFactory<String,ItemMessage> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupid);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
                new JsonDeserializer<>(ItemMessage.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ItemMessage> kafkaListener(){
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.setConsumerFactory(consumerFactory());
        factory.setCommonErrorHandler(new KafkaErrorHandler());  //Handle bad messages in topic

        return factory;
    }

}
