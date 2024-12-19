package com.example.up;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityResult {

    public ResponseEntity<ResponseObject> createResponse(ResponseObject responseObject) {
        HttpStatus status = responseObject.isStatus() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(responseObject, status);
    }
}

