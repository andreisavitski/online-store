package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.mapper.ProductMapper;
import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        if (products.isEmpty()) {
            throw new RuntimeException("No products");
        }
        return products.stream().map(productMapper::mapProductToProductResponseDTO).toList();
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        if (checkIfExist(productRequestDTO.getProductSku())) {
            throw new RuntimeException("A product with this SKU already exists");
        }
        Product product = productMapper.mapProductRequestDTOtoProduct(productRequestDTO);
        productRepository.addProduct(productMapper.mapProductRequestDTOtoProduct(productRequestDTO));
        return productMapper.mapProductToProductResponseDTO(product);
    }

    @Override
    public void updateProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.mapProductRequestDTOtoProduct(productRequestDTO);
        productRepository.updateProduct(product);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return productMapper.mapProductToProductResponseDTO(productRepository.getProductById(id));
    }

    private boolean checkIfExist(String sku) {
        return productRepository.existBySku(sku);
    }

    @Override
    public List<ProductResponseDTO> getAllProductsById(List<Long> listId) {
        productRepository.getAllProducts().stream().filter(product -> product.getProductId().equals(listId.iterator().next()));
        List<Product> products = productRepository.getAllProductsById(listId);
        return products.stream().map(productMapper::mapProductToProductResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }
}
