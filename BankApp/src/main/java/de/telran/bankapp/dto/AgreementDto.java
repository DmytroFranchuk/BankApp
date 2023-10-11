package de.telran.bankapp.dto;

import de.telran.bankapp.entity.Account;
import de.telran.bankapp.entity.Product;
import de.telran.bankapp.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AgreementDto {

    private Long id;
    private Account account;
    private Product product;
    private BigDecimal interestRate;
    private Status statusAgreement;
    private BigDecimal sum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
