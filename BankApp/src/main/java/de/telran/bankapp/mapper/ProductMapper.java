package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
//    @Named("toProductDto")
    @Mapping(source = "manager.id", target = "managerId")
    ProductDto productToDto(Product product);

//    @IterableMapping(qualifiedByName = "toProductDto")
//    List<ProductDto> toListProductDto(List<Product> products);

//    Product dtoToProduct(ProductDto productDto);
}
