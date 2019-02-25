package com.example.shoppingcalculator;

public class Item {
    private String name;
    private Double price;
    private Double quantity;

    public Item() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0.0;
    }

    public Item(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Get and Set for name
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    // Get and Set for price
    public double getPrice() {
        return price;
    }
    public void setPrice(double newPrice){
        price = newPrice;
    }

    // Get and Set for quantity
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double newQuantity) {
        quantity = newQuantity;
    }

    public double getTotal() {
        double total = price * quantity;
        return total;
    }
}
