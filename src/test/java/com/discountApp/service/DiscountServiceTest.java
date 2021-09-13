package com.discountApp.service;

import com.discountApp.model.Bill;
import com.discountApp.model.Discount;
import com.discountApp.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {

    @InjectMocks
    DiscountService discountService;

    @InjectMocks
    List<Discount> discounts = new ArrayList<>();

    @Mock
    Discount discount;

    @Test
    public void applyDiscountTest(){
        Bill bill = new Bill();
        bill.setCustomerType("R");
        bill.setBillAmount(1500);
        when(discount.isEligible(anyString(), anyInt())).thenReturn(true);
        discounts.add(new Discount("R", 1000, 3000, 10));
        ReflectionTestUtils.setField(discountService, "discounts", discounts);
        bill = discountService.applyDiscount(bill);
        Assert.assertEquals(1350, bill.getDiscountedBillAmount());
        Assert.assertEquals(10, bill.getDiscountPercentage());

        List<String> strings = new ArrayList<>();
        strings.add("MH");
        strings.add("MP");
        strings.add("RJ");
        strings.add("KR");
        strings.add("UP");
        List<String> result = strings.stream().filter(e -> !e.startsWith("M")).collect(Collectors.toList());
        System.out.println(result);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Test
    public void test(){
        Employee employee1 = new Employee(1, "ks");
        Employee employee2 = new Employee(1, "ks");

        System.out.println(employee1.equals(employee2));

    }
}
