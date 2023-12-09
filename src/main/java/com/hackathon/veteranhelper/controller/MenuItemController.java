package com.hackathon.veteranhelper.controller;


import com.hackathon.veteranhelper.dto.GetMenuItemDTO;
import com.hackathon.veteranhelper.service.CustomerService;
import com.hackathon.veteranhelper.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/menu-item")
@Slf4j
@RequiredArgsConstructor
public class MenuItemController {

    private final CustomerService customerService;

    private final MenuItemService menuItemService;

    @GetMapping(value = "/{menuItemId}/children")
    public List<GetMenuItemDTO> getChildrenFor(@PathVariable UUID menuItemId) {
        return menuItemService.getChildrenFor(menuItemId);
    }

    @GetMapping
    public UUID getCurrentMenuItemForChatId(@RequestParam Long chatId) {
        return customerService.getCurrentMenuItemForChat(chatId);
    }

    @PostMapping
    public void setCurrentMenuItemForChat(@RequestParam Long chatId, @RequestParam UUID menuItemID) {
        customerService.setCurrentMenuItemForChat(chatId, menuItemID);
    }

    @GetMapping(value = "/{menuItemId}")
    public GetMenuItemDTO getMenuItem(@PathVariable UUID menuItemId){
        return menuItemService.getMenuItem(menuItemId);
    }

}
