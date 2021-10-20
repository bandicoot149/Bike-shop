package main.model;

import main.model.good.Good;
import main.model.good.GoodStats;
import main.model.good.accessory.Accessory;
import main.model.good.accessory.TypeAccessory;
import main.model.good.bike.Bike;
import main.model.good.bike.TypeBike;
import main.model.good.component.Component;
import main.model.good.component.TypeComponent;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String name;
    private static int ID = 0;
    private int id;
    private double balance;
    private List<Good> shoppingСart = new ArrayList<>();
    private List<Good> purchasedGoods = new ArrayList<>();
    private TypeBike neededTypeBike;
    private int neededMinFrameSizeBike;
    private int neededMaxFrameSizeBike;
    private TypeAccessory neededAccessory;
    private TypeComponent neededComponent;

    public Customer() {
        id = ID;
        ID++;
        name = "Покупатель " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Good> getShoppingСart() {
        return shoppingСart;
    }

    public void setShoppingСart(List<Good> shoppingСart) {
        this.shoppingСart = shoppingСart;
    }

    public List<Good> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(List<Good> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public TypeBike getNeededTypeBike() {
        return neededTypeBike;
    }

    public TypeComponent getNeededComponent() {
        return neededComponent;
    }

    public void setNeededComponent(TypeComponent neededComponent) {
        this.neededComponent = neededComponent;
    }

    public void setNeededTypeBike(TypeBike neededTypeBike) {
        this.neededTypeBike = neededTypeBike;
    }

    public int getNeededMinFrameSizeBike() {
        return neededMinFrameSizeBike;
    }

    public TypeAccessory getNeededAccessory() {
        return neededAccessory;
    }

    public void setNeededAccessory(TypeAccessory neededAccessory) {
        this.neededAccessory = neededAccessory;
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

    public void chooseBike(List<Bike> bikes) {
        for (Bike bike : bikes) {
            if ((bike.getType() == this.neededTypeBike) && (bike.getFrameSize() > this.neededMinFrameSizeBike) && (bike.getFrameSize() < this.neededMaxFrameSizeBike)) {
                if (this.balance >= bike.getPrice()) {
                    addGoodToShoppingCart(bike);
                }
            }
        }
    }

    public void chooseAccessories(List<Accessory> accessories) {
        for (Accessory accessory : accessories) {
            if ((accessory.getType() == neededAccessory)) {
                addGoodToShoppingCart(accessory);
            }
        }
    }

    public void chooseComponents(List<Component> components) {
        for (Component component : components) {
            if ((component.getType() == neededComponent)) {
                addGoodToShoppingCart(component);
            }
        }
    }

    private void addGoodToShoppingCart(Good goods) {
        shoppingСart.add(goods);
    }

    public void buySelectedGoods() {
        for (Good good : shoppingСart) {
            if (balance > good.getPrice() && good.getStats() == GoodStats.IN_STOCK && good.getClass() == Bike.class) {
                purchasedGoods.add(good);
                good.setStats(GoodStats.SOLD_OUT);
                balance -= good.getPrice();
                System.out.println(name + " купил велосипед " + ((Bike) good).getBrand());
                break; // покупаем велосипед только один раз
            }
        }

        if (!purchasedGoods.isEmpty()) { /* Если покупатель не купил велосипед, то ему не нужны комплектующие и аксессуары*/
            for (Good good : shoppingСart) {
                if (balance > good.getPrice() && good.getStats() == GoodStats.IN_STOCK && good.getClass() == Component.class) {
                    purchasedGoods.add(good);
                    good.setStats(GoodStats.SOLD_OUT);
                    balance -= good.getPrice();
                    System.out.println(name + " купил компонент " + ((Component) good).getType());
                    break;
                }
            }

            for (Good good : shoppingСart) {
                if (balance > good.getPrice() && good.getStats() == GoodStats.IN_STOCK && good.getClass() == Accessory.class) {
                    purchasedGoods.add(good);
                    good.setStats(GoodStats.SOLD_OUT);
                    balance -= good.getPrice();
                    System.out.println(name + " купил аксессуар " + ((Accessory) good).getType());
                    break;
                }
            }
        }
    }


}
