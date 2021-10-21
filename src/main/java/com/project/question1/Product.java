package com.project.question1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


//This is model class for Product
@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String prodName;
    private String UOM;
    private Double availQty;
    private LocalDate availDate;

}