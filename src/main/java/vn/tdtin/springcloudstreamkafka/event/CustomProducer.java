package vn.tdtin.springcloudstreamkafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component(CustomProducer.NAME)
public class CustomProducer implements Input {
    public static final String NAME = "customProducer";

    private CustomChannel channel;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    public CustomProducer(CustomChannel channel) {
        this.channel = channel;
    }

    public void sendMessage(String message) {
        LOGGER.info("SEND MESSAGE FROM CUSTOM CHANNEL : {}", message);
        Message payload = Message.builder().message(message).id(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now()).build();

        channel.customOutput().send(MessageBuilder.withPayload(payload).build());
    }
}
