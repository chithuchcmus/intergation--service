package com.intergation.service.handler;

import com.intergation.service.Util.QueueUtil;
import com.intergation.service.config.QueueConfig;
import com.intergation.service.model.RequestB1;
import com.intergation.service.model.RequestB2;
import com.intergation.service.model.ResponseA1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProcessB2Handler extends BaseHandler implements handle {

    @Autowired
    private QueueUtil queueUtil;

    @Autowired
    private QueueConfig queueConfig;

    @Override
    public void doHandle(ResponseA1 result) {
        RequestB2 request = new RequestB2();
        request.setNumber(result.getNumber());
        result.setOrderServiceConnect(getNewListServiceConnect(result.getOrderServiceConnect()));
        queueUtil.sendMessage(request,queueConfig.getB2TripleNumberQueue());
    }
    private List<String> getNewListServiceConnect(List<String> list){
        if(list.size() <=0)
            return null;
        return list.subList(1,list.size());
    }
}
