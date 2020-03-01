package com.intergation.service.factory;

import com.intergation.service.contanst.ServiceConnectEnum;
import com.intergation.service.handler.BaseHandler;
import com.intergation.service.handler.ProcessB1Handler;
import com.intergation.service.handler.ProcessB2Handler;
import com.intergation.service.model.RequestA1;

public class GetServerConnectFactory {
    public static BaseHandler getServiceConnect(RequestA1 request){
        if(request == null || request.getOrderServiceConnect().size() <= 0){
            return null;
        }
        String serviceAConnect = request.getOrderServiceConnect().get(0);
        ServiceConnectEnum service = ServiceConnectEnum.valueof(serviceAConnect);
        switch (service){
            case SERVICE_B1:
                return new ProcessB1Handler();
            case SERVICE_B2:
                return new ProcessB2Handler();
        }
        return null;
    }
}
