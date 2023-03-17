package com.example.demo.controller;

import com.example.demo.error.ErrorResponceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponceDto> responseEntity(HttpServerErrorException e) throws JsonProcessingException {
        ErrorResponceDto errorResponceDto = new ErrorResponceDto();
        ErrorResponceDto errorResponce = objectMapper.readValue(e.getResponseBodyAsString(), ErrorResponceDto.class);
        errorResponceDto.setMessage(errorResponce.getMessage());
        log.error("ERROR",e);
        return ResponseEntity.internalServerError().body(errorResponceDto);
    }

}
