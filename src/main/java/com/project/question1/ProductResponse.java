package com.project.question1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private String productId;
    private String prodName;
    private Double availQty;
}
