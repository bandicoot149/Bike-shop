package main.model;

import main.model.good.bike.Bike;
import main.model.good.bike.Brand;
import main.model.good.bike.TypeBike;

public class Promotion {
    private static int ID = 0;
    private int id;
    private Brand brand;
    private TypeBike typeBike;
    private int percent;

    public Promotion() {
        id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TypeBike getTypeBike() {
        return typeBike;
    }

    public void setTypeBike(TypeBike typeBike) {
        this.typeBike = typeBike;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public boolean checkCompliance(Bike bike) {
        boolean chekBrand;
        boolean checkTypeBike;

        if (bike.getBrand() == brand && bike.getType() == typeBike) {
            return true;
        } else {
            return false;
        }

    }
}
