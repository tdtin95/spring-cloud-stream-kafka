package vn.tdtin.springcloudstreamkafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @StreamListener("customInput")
    public void receiveMessage(Message message) {
        LOGGER.info("Receive message from custom channel: {}", message.getMessage());
    }
}
