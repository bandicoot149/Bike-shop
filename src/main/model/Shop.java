package main.model;

import main.model.good.GoodStats;
import main.model.good.accessory.Accessory;
import main.model.good.bike.Bike;
import main.model.good.bike.TypeBike;
import main.model.good.component.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class Shop {
    private double balance = 0;
    private List<Promotion> promotions;
    private List<Bike> bikes;
    private List<Accessory> accessories;
    private List<Component> components;

    public Shop() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Shop(double balance, List<Promotion> promotions, List<Bike> bikes, List<Accessory> accessories, List<Component> components) {
        this.balance = balance;
        this.promotions = promotions;
        this.bikes = bikes;
        this.accessories = accessories;
        this.components = components;
        activatePromotions();
    }

    /* Допущение - магазин единажды применяет этот метод */
    private void activatePromotions() {
        for (Bike bike : bikes) {
            for (Promotion promotion : promotions) {
                if(promotion.checkCompliance(bike)) {
                    bike.setPrice(bike.getPrice()*promotion.getPercent()/100);
                }
            }
        }
    }

    public void makeStatistics () {
        Map<TypeBike, Integer> bikeSales = new HashMap<TypeBike, Integer>();
        for (TypeBike type : TypeBike.values()) {
            bikeSales.put(type, 0);
        }
        for (Bike bike : bikes) {
            if (bike.getStats() == GoodStats.SOLD_OUT) {
                bikeSales.put(bike.getType(), bikeSales.get(bike.getType()) + 1);
            }
        }
        for (TypeBike type : TypeBike.values()) {
            System.out.println(type + " " + bikeSales.get(type));
        }
    }
}
