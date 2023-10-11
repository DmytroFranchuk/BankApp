package de.telran.bankapp.dto;

import de.telran.bankapp.entity.Account;
import de.telran.bankapp.entity.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDto {

    private Long id;

    private Account debitAccount;

    private Account creditAccount;

    private TransactionType type;

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;
}
