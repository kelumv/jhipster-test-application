package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterTestKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-test-kafka")
public class JhipsterTestKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterTestKafkaResource.class);

    private JhipsterTestKafkaProducer kafkaProducer;

    public JhipsterTestKafkaResource(JhipsterTestKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
