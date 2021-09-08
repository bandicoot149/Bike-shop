package model;

import model.bike.Bike;
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

    public boolean checkCompliance (Bike bike) {
        boolean chek_brand;
        boolean check_typeBike;


        // Эти два блока можно написать короче?
        if (brand != null) {
            if (bike.getBrand() == brand) {
                chek_brand = true;
            } else {
                chek_brand = false;
            }
        } else {
            chek_brand = true;
        }

        if (typeBike != null) {
            if (bike.getType() == typeBike) {
                check_typeBike = true;
            } else {
                check_typeBike = false;
            }
        } else {
            check_typeBike = true;
        }

        if (chek_brand && check_typeBike) {
            return true;
        } else {
            return false;
        }
    }
}
