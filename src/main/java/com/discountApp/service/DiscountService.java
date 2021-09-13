package com.discountApp.service;

import com.discountApp.model.Bill;
import com.discountApp.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    @Qualifier(value = "discounts")
    List<Discount> discounts;

    public Bill applyDiscount(Bill bill) {
        for (Discount discount : discounts) {
            if (discount.isEligible(bill.getCustomerType(), bill.getBillAmount())) {
                int pivot = 100 - discount.getDiscountPercentage();
                int finalBillAmount = (pivot * bill.getBillAmount()) / 100;
                bill.setDiscountedBillAmount(finalBillAmount);
                bill.setDiscountPercentage(discount.getDiscountPercentage());
                bill.setMessage("Congratulations you saved " + (bill.getBillAmount() - finalBillAmount));
                break;
            } else {
                bill.setMessage("You are not eligible for discount");
            }
        }
        return bill;
    }
}
