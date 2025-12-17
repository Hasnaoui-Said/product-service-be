package com.pm.productservice.mapper;

import com.pm.productservice.dto.ProductRequestDto;
import com.pm.productservice.dto.ProductResponseDto;
import com.pm.productservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequestDto dto);

    ProductResponseDto toDto(Product product);
}