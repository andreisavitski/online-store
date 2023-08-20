package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.mapper.ProductMapper;

public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product productRequestDTOtoProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductId(productRequestDTO.getProductId());
        product.setProductType(productRequestDTO.getProductType());
        product.setName(productRequestDTO.getName());
        product.setProductSku(productRequestDTO.getProductSku());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantityInStock(productRequestDTO.getQuantityInStock());
        return product;
    }

    @Override
    public ProductResponseDTO productToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getProductId());
        productResponseDTO.setProductType(product.getProductType());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setProductSku(product.getProductSku());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantityInStock(product.getQuantityInStock());
        return productResponseDTO;
    }
}
