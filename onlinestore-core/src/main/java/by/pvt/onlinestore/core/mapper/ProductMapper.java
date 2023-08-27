package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;

public interface ProductMapper {
    Product productRequestDTOtoProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO productToProductResponseDTO(Product product);
}
