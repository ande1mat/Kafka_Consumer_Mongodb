package com.springkafka.unit


import spock.lang.Specification

class ListenerUnitTests extends Specification{

/*
    TopicListener messageListener
    KafkaConfig processor
    Acknowledgment acknowledgment
    ItemMessage itemMessage

    void setup(){
        acknowledgment = Mock(Acknowledgment)
        processor = Mock(KafkaConfig)
        messageListener = Mock(TopicListener)

    }

    def "KafkaMessageListener() - Consume incoming message successfully!"() {
        setup:
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("KafkaMessage.json"));
        //JSONObject jsonObject =  (JSONObject) obj;


        //InputStream is = getClass().getClassLoader().getResourceAsStream("KafkaMessage.json");
        ObjectMapper mapper = new ObjectMapper();
        ItemMessage itemMessage = mapper.readValue(obj, ItemMessage.class);

        when: "Message is consumed from kafka topic"
        messageListener.listen(itemMessage, acknowledgment)

        then: "Expect message to process and receive acknowledgement with no exception thrown"
        1 * processor.kafkaListener(itemMessage) >> true
        1 * acknowledgment.acknowledge()
        noExceptionThrown()
    }


*/


}
