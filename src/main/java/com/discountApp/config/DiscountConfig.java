package com.discountApp.config;

import com.discountApp.DiscountAppApplication;
import com.discountApp.model.Discount;
import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
import org.apache.maven.surefire.shade.org.apache.commons.io.LineIterator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DiscountConfig {

    @Bean(name = "discounts")
    public List<Discount> loadDiscounts(){
        List<Discount> discounts = new ArrayList<>();
        try(InputStream inputStream = DiscountAppApplication.class.getClassLoader().getResourceAsStream("discountInfo.txt")){
            assert inputStream != null;
            LineIterator discountLine = IOUtils.lineIterator(inputStream, StandardCharsets.UTF_8);
            while (discountLine.hasNext()){
                String[] discountInfo = discountLine.next().split(",");
                discounts.add(new Discount(discountInfo[0],
                        Integer.parseInt(discountInfo[1]),
                        Integer.parseInt(discountInfo[2].equalsIgnoreCase("above") ? "999999" : discountInfo[2]),
                        Integer.parseInt(discountInfo[3])));
            }
        }catch (Exception exception){
            exception.printStackTrace();
            return discounts;
        }
        return discounts;
    }
}
