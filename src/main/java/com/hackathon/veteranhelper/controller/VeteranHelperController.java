package com.hackathon.veteranhelper.controller;

import com.hackathon.veteranhelper.entity.HelperRegistrationRequestEntity;
import com.hackathon.veteranhelper.service.HelperRegistrationRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/veteran-helper")
@Slf4j
@RequiredArgsConstructor
public class VeteranHelperController {

    private final HelperRegistrationRequestService registrationService;

    @PostMapping
    public String register(@RequestBody HelperRegistrationRequestEntity registration) {
        return registrationService.registerHelper(registration);
    }

}
