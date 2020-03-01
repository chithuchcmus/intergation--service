package com.intergation.service.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class StringUtil {
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson ;
    public StringUtil(){
        gson  = gsonBuilder.disableHtmlEscaping().create();
    }

    public  String toJsonString(Object object){
        return gson.toJson(object);
    }

    public   <T> T fromJsonString(String json, Class<T> t){
        return gson.fromJson(json,t);
    }
}
