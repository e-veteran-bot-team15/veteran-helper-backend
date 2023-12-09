package com.hackathon.veteranhelper.service.impl;

import com.hackathon.veteranhelper.entity.HelperRegistrationRequestEntity;
import com.hackathon.veteranhelper.service.DouIntegration;
import org.springframework.stereotype.Service;

@Service
public class DouIntegrationImpl implements DouIntegration {
    @Override
    public String sendRegistrationForm(HelperRegistrationRequestEntity helperRegistrationRequestEntity) {
        return "Be sure your registration form was sent :)";
    }
}
