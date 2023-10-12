package de.telran.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.ProductType;
import de.telran.bankapp.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "limit_product")
    private BigDecimal limit;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "product")
//    @JsonManagedReference
//    private List<Agreement> agreements = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(manager, product.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager);
    }
}
