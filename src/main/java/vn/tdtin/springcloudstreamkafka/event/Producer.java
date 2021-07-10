package vn.tdtin.springcloudstreamkafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component(Producer.NAME)
public class Producer implements Input{
    public static final String NAME = "defaultInput";
    private Source source;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    public Producer(Source source) {
        this.source = source;
    }

    @Override
    public void sendMessage(String message) {
        LOGGER.info("SEND MESSAGE : {}", message);
        Message payload = Message.builder().message(message).id(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now()).build();

        source.output().send(MessageBuilder.withPayload(payload).build());
    }
}
