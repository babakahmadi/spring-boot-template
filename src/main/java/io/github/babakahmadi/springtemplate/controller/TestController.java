package io.github.babakahmadi.springtemplate.controller;

import io.github.babakahmadi.springtemplate.KafkaService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TestController {

    @Autowired
    private KafkaService kafkaService;

    @Timed(value = "test", description = "Time taken for test")
    @GetMapping(value = "")
    public String test() {
        log.info("test is called");
        return "Hello World!";
    }


    @Timed(value = "sendKafka", description = "Time taken for send kafka")
    @GetMapping(value = "/kafka-send")
    public String sendKafka() {
        kafkaService.sendMessage("message");
        return "sent";
    }

}
