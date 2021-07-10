package vn.tdtin.springcloudstreamkafka.event;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class Message {
    private String id;
    private String message;
    private OffsetDateTime dateTime;
}
