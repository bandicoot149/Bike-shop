package main.model.good;

public abstract class Good {
    private static int ID = 0;
    private int id;
    private double price;
    private GoodStats stats = GoodStats.IN_STOCK;

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

    public GoodStats getStats() {
        return stats;
    }

    public void setStats(GoodStats stats) {
        this.stats = stats;
    }
}
