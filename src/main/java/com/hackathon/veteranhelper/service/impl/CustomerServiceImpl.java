package com.hackathon.veteranhelper.service.impl;

import com.hackathon.veteranhelper.repository.CustomerRepository;
import com.hackathon.veteranhelper.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public UUID getCurrentMenuItemForChat(Long chatId) {
        return customerRepository.getCurrentMenuItemForChat(chatId);
    }

    @Override
    public void setCurrentMenuItemForChat(Long chatId, UUID menuItemId) {
        customerRepository.setCurrentMenuItemForChatId(menuItemId, chatId);
    }

}
