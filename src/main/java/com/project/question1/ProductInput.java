package com.project.question1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductInput {
    private String productId;
    private String prodName;
    private LocalDate availDate;
}
