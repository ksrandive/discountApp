package com.discountApp.controller;

import com.discountApp.model.Bill;
import com.discountApp.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping(path = "/discount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Bill getDiscount(@RequestBody Bill bill){
        return discountService.applyDiscount(bill);
    }
}
