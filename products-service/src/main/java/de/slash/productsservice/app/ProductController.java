package de.slash.productsservice.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.slash.productsservice.product.Product;
import de.slash.productsservice.product.ProductDTO;
import de.slash.productsservice.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @MutationMapping
    private Long createProduct(@Argument("productDTO") ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(productDTO.getName(), productDTO.getPrice());
        return createdProduct.getId();
    }

    @QueryMapping
    private Product getProduct(@Argument("id") Long id) {
        return productService.getById(id);
    }

    @MutationMapping
    private Long deleteProduct(@Argument("id") Long id) {
        Product product = productService.getById(id);
        productService.deleteProduct(product);
        return product.getId();
    }
}
