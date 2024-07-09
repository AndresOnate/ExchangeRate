package org.edu.oracle.model;

import com.google.gson.JsonObject;
import org.edu.oracle.controller.ExChangeController;

import java.util.function.DoubleUnaryOperator;

import com.google.gson.JsonObject;

public class Conversor {

    private Double usdToArsRate;
    private Double usdToBrlRate;
    private Double usdToCopRate;

    public Conversor() {
        JsonObject conversionRates = ExChangeController.getConversionRates("USD");
        usdToArsRate = Double.parseDouble(conversionRates.get("ARS").getAsString());
        usdToBrlRate = Double.parseDouble(conversionRates.get("BRL").getAsString());
        usdToCopRate = Double.parseDouble(conversionRates.get("COP").getAsString());
    }

    public Double USDToARS(Double amount) {
        return amount * usdToArsRate;
    }

    public Double ARSToUSD(Double amount) {
        return amount / usdToArsRate;
    }

    public Double USDToBRL(Double amount) {
        return amount * usdToBrlRate;
    }

    public Double BRLToUSD(Double amount) {
        return amount / usdToBrlRate;
    }

    public Double USDToCOP(Double amount) {
        return amount * usdToCopRate;
    }

    public Double COPToUSD(Double amount) {
        return amount / usdToCopRate;
    }
}
