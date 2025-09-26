package com.example.learningspringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider",havingValue = "Stripes")
public class Stripes implements Paymentvia{
    public String pay(){
        String btr="payment from stripes";
        System.out.println(btr);
        return btr;
    }
}
