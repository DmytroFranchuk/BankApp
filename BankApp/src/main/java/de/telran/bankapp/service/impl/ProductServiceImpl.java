package de.telran.bankapp.service.impl;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.Product;
import de.telran.bankapp.mapper.ProductMapper;
import de.telran.bankapp.repository.ProductRepository;
import de.telran.bankapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? productMapper.productToDto(product) : null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ProductDto> getProductsByManagerId(Long managerId) {
//        List<Product> products = productRepository.findByManagerId(managerId);
//        return products.stream()
//                .map(productMapper::productToDto)
//                .collect(Collectors.toList());
//    }
}
