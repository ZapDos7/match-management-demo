package com.example.demo.web.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

public class CreateMatchOddsRequest {
    @Pattern(regexp = "1|2|X", message = "Specifier must be '1', '2', or 'X'")
    private String specifier;
    /* Usually >1. Can be =1 if the match is cancelled, therefore a refund ensues. */
    @DecimalMin(value = "1.0", message = "Odd must be greater or equals than 1.0")
    private double odd;

    public CreateMatchOddsRequest() {
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}
