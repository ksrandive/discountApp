package com.discountApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private String customerType;
    private int minPrice;
    private int maxPrice;
    private int discountPercentage;

    public boolean isEligible(String customerType, int discountAmount){
        return customerType.equalsIgnoreCase(this.customerType) && isBetweenSlab(discountAmount);
    }

    private boolean isBetweenSlab(int discountAmount){
        return discountAmount <= this.maxPrice && discountAmount >= minPrice;
    }
}
