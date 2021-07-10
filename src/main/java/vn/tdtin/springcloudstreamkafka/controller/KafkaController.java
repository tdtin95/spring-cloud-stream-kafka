package vn.tdtin.springcloudstreamkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.tdtin.springcloudstreamkafka.event.CustomProducer;
import vn.tdtin.springcloudstreamkafka.event.InputFactory;
import vn.tdtin.springcloudstreamkafka.event.Producer;

@RestController
@RequestMapping("/api/message")
public class KafkaController {
    private InputFactory inputFactory;

    @Autowired
    public KafkaController(InputFactory inputFactory) {
        this.inputFactory = inputFactory;
    }

    @PutMapping
    public ResponseEntity<Void> sendMessage(@RequestParam("message") String message, @RequestParam(value = "channel", required = false) String channel) {
        inputFactory.getInput(channel).sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
