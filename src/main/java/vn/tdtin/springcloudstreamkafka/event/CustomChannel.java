package vn.tdtin.springcloudstreamkafka.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface CustomChannel {

    @Input("customInput")
    SubscribableChannel customInput();

    @Output("customOutPut")
    MessageChannel customOutput();

}
