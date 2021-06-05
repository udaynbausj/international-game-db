package io.code.gamedb.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {

    @Autowired
    private Processor processor;

    public void send(Object payload) {
        Class<?> clazz = payload.getClass();
        Message<?>message = MessageBuilder.withPayload(payload).build();
        processor.output().send(message);
    }

}
