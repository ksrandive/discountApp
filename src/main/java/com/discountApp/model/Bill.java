package com.discountApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private String customerType;
    private int billAmount;
    private int discountedBillAmount;
    private int discountPercentage;
    private String message;
}
