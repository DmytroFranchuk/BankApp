package de.telran.bankapp.repository;

import de.telran.bankapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
