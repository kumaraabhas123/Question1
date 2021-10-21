package com.project.question1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Represents controller class
 */
@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    /**
     * Add new product using POST method
     *
     * @param productInput Object of Product which stores values entered by user
     * @return the product added by user
     */
    @PostMapping(value="/searchProduct")
        public ResponseEntity<ProductResponse> searchProduct(@RequestBody ProductInput productInput) {
             service.getProduct();
             double quantity= service.searchProduct(productInput);
        if(quantity!=0)
        {
            ProductResponse productResponse = new ProductResponse(productInput.getProductId(),productInput.getProdName(), quantity);
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}