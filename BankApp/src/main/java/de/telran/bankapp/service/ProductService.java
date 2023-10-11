package de.telran.bankapp.service;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    ProductDto getById(Long id);

    List<ProductDto> getAllProducts();

//    List<ProductDto> getProductsByManagerId(Long managerId);
}
