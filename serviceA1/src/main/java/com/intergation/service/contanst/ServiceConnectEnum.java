package com.intergation.service.contanst;

import java.util.HashMap;
import java.util.Map;

public enum  ServiceConnectEnum {
    SERVICE_B1("B1"),
    SERVICE_B2("B2");

    private final String type;

    private static Map listServiceConnect = new HashMap<>();

    private ServiceConnectEnum(final String type) {
        this.type = type;
    }
    static {
        for (ServiceConnectEnum serviceConnectEnum : ServiceConnectEnum.values()) {
            listServiceConnect.put(serviceConnectEnum.getType(), serviceConnectEnum);
        }
    }
    public String getType(){
        return type;
    }
    public static ServiceConnectEnum valueof(String type){
        ServiceConnectEnum service = (ServiceConnectEnum) listServiceConnect.get(type);
        if(service == null){
            throw new IllegalArgumentException("Not Enum constant was found for value : " + type);
        }
        return service;
    }

    public static boolean isExistServiceConnect(ServiceConnectEnum type){
        return listServiceConnect.containsValue(type);
    }
}
