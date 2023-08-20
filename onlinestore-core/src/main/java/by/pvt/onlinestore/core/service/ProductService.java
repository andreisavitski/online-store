package by.pvt.onlinestore.core.service;

import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);

    void changeOfProductInformation(ProductRequestDTO productRequestDTO);

    ProductResponseDTO viewProductInformation(Long id);
    boolean checkIfExist(String sku);

}
