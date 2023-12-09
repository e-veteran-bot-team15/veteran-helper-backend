package com.hackathon.veteranhelper.service;

import java.util.UUID;


public interface CustomerService {

    UUID getCurrentMenuItemForChat(Long chatId);

    void setCurrentMenuItemForChat(Long chatId, UUID menuItemId);

}
