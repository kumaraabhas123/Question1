package com.project.question1;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class ProductServiceImpl implements ProductService {

    /**
     * This List stores hardcoded Product details.
     */
    private static List<Product> InventoryList = new ArrayList<>();

    /**
     * This method is created to get product details with all attributes.
     * When this method is called, three new products are added in the InventoryList
     * with details like Product id, Product name, UOM, Available quantity and Date.
     */
    @Override
    public void getProduct() {

            InventoryList.add(new Product("Prod1", "Shirt", "Each", 10.0, LocalDate.of(2021,03,19)));
            InventoryList.add(new Product("Prod1", "Trousers", "Each", 20.0, LocalDate.of(2021,03,21)));
            InventoryList.add(new Product("Prod1", "Trousers", "Each", 20.0, LocalDate.of(2021,03,29)));
    }

    /**
     * This method is created to add new Product by user in InventorySearchList.
     * Add new product in InventorySearchList using POST method.
     * Here, Date1 = Available Date of the product added by user in InventorySearchList.
     *       Date2 = Date1 + 10 days
     *       Date3 = Available Date of the hardcoded product in InventoryList.
     * LOGIC: Check Date1 is valid or not, if not valid it returns BAD REQUEST
     *        If valid, check valid date for every product in InventoryList
     *        If valid, add the Available Quantity of products in variable quantity.
     *        Then return Available Quantity on required date.
     *
     * @param productInput object of ProductInput
     * @return Available quantity
     */
    @Override
    public double searchProduct(ProductInput productInput) {

        LocalDate Date1=  productInput.getAvailDate();
        LocalDate Date2= Date1.plusDays(10);

        double quantity= 0;
        if(Date1.isAfter(LocalDate.of(2021,03,18)) && Date1.isBefore(LocalDate.of(2021,03,31)))
        {
         for(Product i:InventoryList)
         {
             LocalDate Date3= i.getAvailDate();
             if(Date3.isAfter(Date1.minusDays(1)) && Date3.isBefore(Date2.plusDays(1)))
             {
                 quantity= quantity + i.getAvailQty();
             }
         }
            return quantity;
        }
        else
            return quantity;
    }
}
