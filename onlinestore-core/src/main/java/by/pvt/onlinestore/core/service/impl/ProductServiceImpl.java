package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.mapper.ProductMapper;
import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.service.ProductService;

import java.util.List;

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
        return products.stream().map(productMapper::productToProductResponseDTO).toList();
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        if (checkIfExist(productRequestDTO.getProductSku())) {
            throw new RuntimeException("The sku " + productRequestDTO.getProductSku() + " entered already exists. Enter another sku.");
        }
        Product product = productMapper.productRequestDTOtoProduct(productRequestDTO);
        productRepository.addProduct(productMapper.productRequestDTOtoProduct(productRequestDTO));
        return productMapper.productToProductResponseDTO(product);
    }

    @Override
    public void changeOfProductInformation(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.productRequestDTOtoProduct(productRequestDTO);
        Product newProduct = productRepository.getProductByIdForChange(product.getProductId());
        newProduct.setName(product.getName());
        newProduct.setProductSku(product.getProductSku());
        newProduct.setProductType(product.getProductType());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantityInStock(product.getQuantityInStock());
        newProduct.setDescription(product.getDescription());
        productRepository.addOldProduct(newProduct);
//        productRepository.deleteProductWithoutSaving(product.getProductId());
//        productRepository.addOldProduct(newProduct);
    }

    @Override
    public ProductResponseDTO viewProductInformation(Long id) {
        return productMapper.productToProductResponseDTO(productRepository.getProductById(id));
    }

    @Override
    public boolean checkIfExist(String sku) {
        return productRepository.findBySku(sku);
    }
}
