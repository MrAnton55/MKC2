package com.example.demo.error;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ErrorResponceDto {
    private String message;
}
