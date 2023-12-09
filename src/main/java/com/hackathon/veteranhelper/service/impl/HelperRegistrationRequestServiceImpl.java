package com.hackathon.veteranhelper.service.impl;

import com.hackathon.veteranhelper.entity.HelperRegistrationRequestEntity;
import com.hackathon.veteranhelper.repository.HelperRegistrationRequestRepository;
import com.hackathon.veteranhelper.service.DateTimeService;
import com.hackathon.veteranhelper.service.DouIntegration;
import com.hackathon.veteranhelper.service.HelperRegistrationRequestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HelperRegistrationRequestServiceImpl implements HelperRegistrationRequestService {

    private final HelperRegistrationRequestRepository repository;

    private final DateTimeService dateTimeService;

    private final DouIntegration douIntegration;

    @Override
    @Transactional
    public String registerHelper(HelperRegistrationRequestEntity registrationEntity) {
        Optional<HelperRegistrationRequestEntity> byId = repository.findById(registrationEntity.getChatId());
        byId.ifPresent(helperRegistrationRequestEntity -> helperRegistrationRequestEntity.copyAllNonNullFields(registrationEntity));
        HelperRegistrationRequestEntity savedEntity = byId.orElse(setTimestamp(registrationEntity));
        repository.saveAndFlush(savedEntity);
        if(savedEntity.allFieldNotNull()) {
            return douIntegration.sendRegistrationForm(savedEntity);
        }
        return "More fields needed: " + savedEntity;
    }

    private HelperRegistrationRequestEntity setTimestamp(HelperRegistrationRequestEntity registrationEntity) {
        registrationEntity.setCreationTimestamp(dateTimeService.now());
        return registrationEntity;
    }

}
