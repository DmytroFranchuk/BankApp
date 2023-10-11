package de.telran.bankapp.dto;

import de.telran.bankapp.entity.Client;
import de.telran.bankapp.entity.enums.AccountType;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.Status;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountDto {

    private Long id;

    private Client client;

    private String name;

    private AccountType type;

    private Status statusAccount;

    private BigDecimal balance;

    private CurrencyCode currencyCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    private Agreement agreement;
//    private List<Transaction> debitTransactions = new ArrayList<>();
//    private List<Transaction> creditTransactions = new ArrayList<>();
}
