package vn.tdtin.springcloudstreamkafka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@Configuration
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<vn.tdtin.springcloudstreamkafka.event.Message> message) {
        final Integer partitionId = message.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class);
        LOGGER.info("Receive message : {}, partitionId {}", message.getPayload(), partitionId);
    }
}
