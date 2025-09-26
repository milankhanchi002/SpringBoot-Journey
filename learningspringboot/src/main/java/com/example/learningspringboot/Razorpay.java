package com.example.learningspringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//@Repository
//@Service

//Bean Instantiation = Spring creates objects of classes marked with @Component, @Service, @Repository, etc.
//
//Dependency Injection = Spring provides those objects where needed (via constructor, setter, or field mtlb autowired).
//
//So DI = Instantiation + Injection at the right place, automatically handled by Spring’s IoC (Inversion of Control) container.
@Component //bean bn gya h mtlb obj
@ConditionalOnProperty(name="payment.provider",havingValue = "Razorpay")
public class Razorpay implements Paymentvia {
    public  String pay(){
        String str="payment from Razorpay";
        System.out.println(str);
        return str;
    }
}
