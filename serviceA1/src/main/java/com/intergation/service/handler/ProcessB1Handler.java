package com.intergation.service.handler;

import com.intergation.service.Util.QueueUtil;
import com.intergation.service.config.QueueConfig;
import com.intergation.service.model.RequestA1;
import com.intergation.service.model.RequestB1;
import com.intergation.service.model.ResponseA1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProcessB1Handler extends BaseHandler implements handle {

    @Autowired
    private QueueUtil queueUtil;

    @Autowired
    private QueueConfig queueConfig;

    @Override
    public void doHandle(ResponseA1 result) {
        RequestB1 request = new RequestB1();
        request.setNumber(result.getNumber());
        result.setOrderServiceConnect(getNewListServiceConnect(result.getOrderServiceConnect()));
        queueUtil.sendMessage(request,queueConfig.getB1DoubleNumberQueue());
    }
    private List<String> getNewListServiceConnect(List<String> list){
        if(list.size() <=0)
            return null;
        return list.subList(1,list.size());
    }
}
