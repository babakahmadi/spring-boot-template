package io.github.babakahmadi.springtemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import io.github.babakahmadi.springtemplate.model.Message;

@Component
@Slf4j
class KafkaListenersExample {

    @KafkaListener(
            topics = "test",
            groupId="test",
            containerFactory="messageKafkaListenerContainerFactory")
    void listener(Message data) {
        log.info("listen to test topic: {}",data);
    }

}