package com.hackathon.veteranhelper.config;

import com.hackathon.veteranhelper.repository.HelperRegistrationRequestRepository;
import com.hackathon.veteranhelper.service.DateTimeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

@Configuration
@RequiredArgsConstructor
public class DbClearanceConfig {

    private static final int DESIRED_HOUR_TO_CLEAR_DATABASE = 4;

    public static final int UKRAINE_OFFSET = 2;

    private final TaskScheduler taskScheduler;

    private final HelperRegistrationRequestRepository repository;

    private final DateTimeService dateTimeService;

    @PostConstruct
    public void scheduleSiteWatchers() {
        taskScheduler.scheduleWithFixedDelay(clearRecordsOlderThan1Day(), getDesiredStartExecutionTime(), Duration.ofDays(1));
    }

    private Runnable clearRecordsOlderThan1Day() {
        return () -> {
            repository.deleteAllOlderThen(dateTimeService.now().minus(1, ChronoUnit.DAYS));
            repository.flush();
        };
    }

    private Instant getDesiredStartExecutionTime(){
        LocalDateTime startTime = dateTimeService.now();
        startTime = startTime.minus(Duration.ofMillis(startTime.getLong(ChronoField.MILLI_OF_SECOND)))
                .minus(Duration.ofSeconds(startTime.getSecond()))
                .minus(Duration.ofMinutes(startTime.getMinute()))
                .minus(Duration.ofHours(startTime.getHour()))
                .plus(Duration.ofDays(1))
                // 1 here because next day will ensure that this task will
                // be executed exactly at DESIRED_HOUR_TO_CLEAR_DATABASE
                .plus(Duration.ofHours(DESIRED_HOUR_TO_CLEAR_DATABASE));
        return startTime.toInstant(ZoneOffset.ofHours(UKRAINE_OFFSET));
    }

}
