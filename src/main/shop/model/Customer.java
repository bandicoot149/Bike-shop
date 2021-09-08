package model;

import model.bike.Bike;
import model.bike.TypeBike;

import java.util.List;

public class Customer {
    private static int ID = 0;
    private int id;
    private double balance;
    private List<Goods> shoppingСart;
    private List<Goods> purchasedBikes;
    private TypeBike neededType;
    private int neededMinFrameSizeBike;
    private int neededMaxFrameSizeBike;

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

    public List<Goods> getShoppingСart() {
        return shoppingСart;
    }

    public void setShoppingСart(List<Goods> shoppingСart) {
        this.shoppingСart = shoppingСart;
    }

    public List<Goods> getPurchasedBikes() {
        return purchasedBikes;
    }

    public void setPurchasedBikes(List<Goods> purchasedBikes) {
        this.purchasedBikes = purchasedBikes;
    }

    public TypeBike getNeededType() {
        return neededType;
    }

    public void setNeededType(TypeBike neededType) {
        this.neededType = neededType;
    }

    public int getNeededMinFrameSizeBike() {
        return neededMinFrameSizeBike;
    }

    public void setNeededMinFrameSizeBike(int neededMinFrameSizeBike) {
        this.neededMinFrameSizeBike = neededMinFrameSizeBike;
    }

    public int getNeededMaxFrameSizeBike() {
        return neededMaxFrameSizeBike;
    }

    public void setNeededMaxFrameSizeBike(int neededMaxFrameSizeBike) {
        this.neededMaxFrameSizeBike = neededMaxFrameSizeBike;
    }

    public void chooseBike (List<Bike> bikes) {
        for (Bike bike: bikes) {
            if ((bike.getType() == this.neededType) && (bike.getFrameSize() > this.neededMinFrameSizeBike) && (bike.getFrameSize() < this.neededMaxFrameSizeBike)) {
                if (this.balance >= bike.getPrice()) {
                    this.addGoodToShoppingCart(bike);
                    break;
                    /* пока что покупатель выбирает только один велосипед
                    но можно добавить в корзину все подходящие а затем выбрать
                    один из них по желанию покупателя (рандомно)
                     */
                }
            }
        }
    }

    public void addGoodToShoppingCart (Goods goods) {
        shoppingСart.add(goods);
    }


}
