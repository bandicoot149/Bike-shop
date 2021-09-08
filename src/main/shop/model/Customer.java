package model;

import model.bike.Bike;

import java.util.List;

public class Customer {
    private static int ID = 0;
    private int id;
    private double balance;
    private List<Bike> ShoppingСart;
    private List<Bike> purchasedBikes;

    public Customer() {
        id = ID;
        ID++;
    }

    public int getId() { return id; }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Bike> getShoppingСart() {
        return ShoppingСart;
    }

    public void setShoppingСart(List<Bike> shoppingСart) {
        ShoppingСart = shoppingСart;
    }

    public List<Bike> getPurchasedBikes() {
        return purchasedBikes;
    }

    public void setPurchasedBikes(List<Bike> purchasedBikes) {
        this.purchasedBikes = purchasedBikes;
    }
}
