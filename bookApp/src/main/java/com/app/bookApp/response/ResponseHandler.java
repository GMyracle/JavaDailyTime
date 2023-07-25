package com.app.bookApp.response;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity responseBuilder(
            String message,
            ResponseEntity responseEntity,
            Object responseObject

    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", responseEntity);
        response.put("data", responseObject);


        return new ResponseEntity<>(response, responseEntity.getStatusCode());
    }
}
