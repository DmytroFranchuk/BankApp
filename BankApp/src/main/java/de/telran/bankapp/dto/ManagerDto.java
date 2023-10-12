package de.telran.bankapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerDto {

    private String id;
    private String firstName;
    private String lastName;
    private String status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
