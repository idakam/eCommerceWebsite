package com.ecommerce.ecommerceProject.model;

import lombok.Builder;
import lombok.Data;

@Data
public class ChargeRequest {
    public  enum Currency{
        EUR, USD, GBP;
    }
    private String Description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
}

