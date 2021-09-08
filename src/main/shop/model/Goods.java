package model;

public abstract class Goods {
    private static int ID = 0;
    private int id;
    private double price;

    public Goods() {
        id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
