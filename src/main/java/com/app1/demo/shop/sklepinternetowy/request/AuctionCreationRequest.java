package com.app1.demo.shop.sklepinternetowy.request;


public class AuctionCreationRequest {

    private String name;
    private double price;
    private int amount;

    public AuctionCreationRequest(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public AuctionCreationRequest() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "AuctionCreationRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
