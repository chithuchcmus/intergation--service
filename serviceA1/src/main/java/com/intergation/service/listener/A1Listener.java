package com.intergation.service.listener;

import com.intergation.service.Util.StringUtil;
import com.intergation.service.factory.GetServerConnectFactory;
import com.intergation.service.handler.BaseHandler;
import com.intergation.service.model.RequestA1;
import com.intergation.service.model.ResponseA1;
import com.intergation.service.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class A1Listener {

    @Autowired
    MainService service;

    @Autowired
    StringUtil stringUtil;

    @KafkaListener(topics = "${kafka.topic.a1}",groupId = "${kafka.a1.groupId}")
    public void processDetectObject(String  message){
        if(message == null || message.equals("")){
            return;
        }
        try{
            RequestA1 request = stringUtil.fromJsonString(message,RequestA1.class);
            ResponseA1 response = service.processRequest(request);
            BaseHandler baseHandler = GetServerConnectFactory.getServiceConnect(request);
            if(baseHandler == null) {
                return;
            }
            baseHandler.doHandle(response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
