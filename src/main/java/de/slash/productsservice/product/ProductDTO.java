package de.slash.productsservice.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private BigDecimal price;
}
