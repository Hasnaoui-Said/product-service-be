package com.pm.productservice.service.impl;

import com.pm.productservice.dto.ProductRequestDto;
import com.pm.productservice.dto.ProductResponseDto;
import com.pm.productservice.entity.Product;
import com.pm.productservice.exception.ResourceNotFoundException;
import com.pm.productservice.mapper.ProductMapper;
import com.pm.productservice.repository.ProductRepository;
import com.pm.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Product product = mapper.toEntity(dto);
        product.setCreatedAt(LocalDateTime.now());
        return mapper.toDto(repository.save(product));
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return mapper.toDtoList(productRepository.findAll());
    }




}
