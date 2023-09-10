package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;

import java.sql.ResultSet;

public interface ProductMapper {
    Product mapProductRequestDTOtoProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO mapProductToProductResponseDTO(Product product);

    Product mapResultSerToProduct(ResultSet resultSet);
}
