package de.telran.bankapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManagerInfoDto {
    private String managerId;
    private List<String> clientId;
//    private List<ProductDto> products;
}
