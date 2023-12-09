package com.hackathon.veteranhelper.service.impl;

import com.hackathon.veteranhelper.dto.GetMenuItemDTO;
import com.hackathon.veteranhelper.entity.MenuItemEntity;
import com.hackathon.veteranhelper.repository.MenuItemRepository;
import com.hackathon.veteranhelper.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public List<GetMenuItemDTO> getChildrenFor(UUID menuItemId) {
        return menuItemRepository.getChildrenFor(menuItemId).stream().map(this::mapToGetDTO).toList();
    }

    @Override
    public GetMenuItemDTO getMenuItem(UUID menuItemId) {
        return menuItemRepository.findById(menuItemId).stream().map(this::mapToGetDTO).findFirst().orElseThrow();
    }

    private GetMenuItemDTO mapToGetDTO(MenuItemEntity e) {
        return GetMenuItemDTO.builder()
                .withId(e.getId())
                .withMessage(e.getMessage())
                .build();
    }
}
