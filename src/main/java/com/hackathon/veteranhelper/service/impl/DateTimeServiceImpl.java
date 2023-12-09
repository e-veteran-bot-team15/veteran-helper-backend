package com.hackathon.veteranhelper.service.impl;

import com.hackathon.veteranhelper.service.DateTimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
