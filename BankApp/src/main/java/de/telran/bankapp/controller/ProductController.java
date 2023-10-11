package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.Product;
import de.telran.bankapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/dto")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDto getById(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getById(id);
        if (productDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is id " + id + " not find");
        }
        return productDto;
    }
}
