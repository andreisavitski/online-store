package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.domain.ProductType;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.mapper.ProductMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapperImpl implements ProductMapper {
    private final String id = "id";
    private final String sku = "sku";
    private final String name = "name";
    private final String type = "type";
    private final String price = "price";
    private final String description = "description";
    private final String quantity = "quantity";

    @Override
    public Product mapProductRequestDTOtoProduct(ProductRequestDTO productRequestDTO) {
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
    public ProductResponseDTO mapProductToProductResponseDTO(Product product) {
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

    @Override
    public Product mapResultSerToProduct(ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setProductId(resultSet.getLong(id));
            product.setProductSku(resultSet.getString(sku));
            product.setName(resultSet.getString(name));
            product.setProductType(ProductType.valueOf(resultSet.getString(type)));
            product.setPrice(resultSet.getLong(price));
            product.setDescription(resultSet.getString(description));
            product.setQuantityInStock(resultSet.getInt(quantity));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

}
