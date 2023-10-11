package de.telran.bankapp.dto;

import de.telran.bankapp.entity.Agreement;
import de.telran.bankapp.entity.Product;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.ProductType;
import de.telran.bankapp.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDto {

    private Long id;
    private String managerId;
    private ProductType type;
    private Status status;
    private CurrencyCode currencyCode;
    private BigDecimal interestRate;
    private BigDecimal limit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private List<Agreement> agreements;
}
