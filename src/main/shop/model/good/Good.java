package model.good;

public abstract class Good {
    private static int ID = 0;
    private int id;
    private double price;

    public Good() {
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
