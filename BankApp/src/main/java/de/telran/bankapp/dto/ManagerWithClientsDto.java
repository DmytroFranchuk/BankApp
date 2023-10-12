package de.telran.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ManagerWithClientsDto {

    private String managerId;
    private List<String> clientIds;
}
