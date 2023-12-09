package com.hackathon.veteranhelper.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder(setterPrefix = "with")
@Data
public class GetMenuItemDTO {

    private UUID id;

    private String message;

}
