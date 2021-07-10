package vn.tdtin.springcloudstreamkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import vn.tdtin.springcloudstreamkafka.event.CustomChannel;

@SpringBootApplication
@EnableBinding({Processor.class, CustomChannel.class})
public class SpringCloudStreamKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
    }
}
