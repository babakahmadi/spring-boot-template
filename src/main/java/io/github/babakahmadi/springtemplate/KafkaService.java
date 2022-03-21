package io.github.babakahmadi.springtemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import io.github.babakahmadi.springtemplate.model.Message;

@Slf4j
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Value(value = "${kafka.topic-name}")
    private String topicName;

    public void sendMessage(String message) {

        Message messageObj = new Message();
        messageObj.setName(message);
        messageObj.setValue(12);
        messageObj.setDescription("some description");

        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(topicName, messageObj);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                log.info("Sent message=[{}] with offset=[{}]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to : ", message, ex.getMessage());
            }
        });
    }

}
