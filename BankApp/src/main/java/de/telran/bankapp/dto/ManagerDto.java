package de.telran.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.bankapp.entity.Client;
import de.telran.bankapp.entity.Product;
import de.telran.bankapp.entity.enums.Status;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ManagerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Status status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private List<Product> products;
//    private List<Client> clients;
}
