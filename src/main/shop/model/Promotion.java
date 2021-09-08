package model;

import model.bike.Brand;
import model.bike.TypeBike;

public class Promotion {
    private static int ID = 0;
    private int id;
    private Brand brand;
    private TypeBike typeBike;

    public Promotion() {
        brand = null;
        typeBike = null;
        id = ID;
        ID++;
    }

    public int getId() { return id; }

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
}
