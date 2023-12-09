package com.hackathon.veteranhelper.service;

import com.hackathon.veteranhelper.dto.GetMenuItemDTO;

import java.util.List;
import java.util.UUID;

public interface MenuItemService {

    List<GetMenuItemDTO> getChildrenFor(UUID menuItemId);

    GetMenuItemDTO getMenuItem(UUID menuItemId);

}
