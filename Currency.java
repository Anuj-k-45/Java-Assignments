import java.util.*;

public class Currency {
    String currencyCode;
    String currencyName;
    double exchangeRate;

    public Currency() {
        this.currencyCode = "IND";
        this.currencyName = "Rupee";
        this.exchangeRate = 70.32;
    }

    public Currency(String currencyCode, String currencyName, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
    }

    public void calc() {
        double euroToInr = 90.05; 
        double usdToInr = 70.32;
        double poundToInr = 107.53;

        int euro = 50;
        int usd = 30;
        int pound = 20;

        double total_rupees = (euro * euroToInr) + (usd * usdToInr) + (pound * poundToInr);

        System.out.println("Total INR rupees required: " + total_rupees);
    }

    public static void main(String[] args) {
        Currency currency = new Currency();
        currency.calc();
    }
}