package com.intergation.service.Util;

import com.intergation.service.config.QueueConfig;
import com.intergation.service.model.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class QueueUtil {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    StringUtil stringUtil;

    @Autowired
    QueueConfig queueConfig;

    private static final Logger logger = Logger.getLogger(StringUtil.class.getSimpleName());


    public boolean sendMessage(BaseRequest request, String topic) {
        try{
            Message<String> message = MessageBuilder
                    .withPayload(stringUtil.toJsonString(request))
                    .setHeader(KafkaHeaders.TOPIC,topic)
                    .build();
            kafkaTemplate.send(message);
            return true;
        }catch (Exception e){
            logger.info("process detect false on send message to kafka log detect");
            return false;
        }

    }
}
