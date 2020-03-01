package com.intergation.service.service;

import com.intergation.service.model.RequestA1;
import com.intergation.service.model.ResponseA1;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public ResponseA1 processRequest(RequestA1 request) {
        ResponseA1 response = getInfoFromRequest(request);
        long result = sumTwoNumber(request.getNumber1(), request.getNumber2());
        response.setNumber(result);
        return response;
    }

    private ResponseA1 getInfoFromRequest(RequestA1 request) {
        ResponseA1 response = new ResponseA1();
        response.setOrderServiceConnect(request.getOrderServiceConnect());
        return response;
    }

    private long sumTwoNumber(int a, int b) {
        return a + b;
    }
}
