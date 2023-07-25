package com.app.bookApp.response;

import java.util.HashMap;

public class ResponseData<T> extends BaseObject {
    private int statusCode;
    private String message;
    private T data;
    private HashMap<String, String> headers;

    public ResponseData(int statusCode, String message, T data, HashMap<String, String> headers) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.headers = headers;
    }

}
