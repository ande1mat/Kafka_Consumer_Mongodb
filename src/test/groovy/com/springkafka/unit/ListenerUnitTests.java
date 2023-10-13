package com.springkafka.unit;

/*
import com.springkafka.listener.TopicListener;
import com.springkafka.service.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.springkafka.domain.ItemMessage
import com.springkafka.listener.TopicListener;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ListenerUnitTests {


    @Mock
    MessageConsumerService messageConsumerService;
    ConsumerService service;

    @InjectMocks
    TopicListener topicListener;
    MessageConsumer messageConsumer;

    @Test
    void listenerTest(){
        ConsumerRecord<String, String> record = new ConsumerRecord<>("topic", 0, 123L, "key", "value");
        topicListener.listen(record);
        verify(service, times(1)).process(anyString());

    }


}
*/