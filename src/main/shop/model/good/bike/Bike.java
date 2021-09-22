package model.good.bike;

import model.good.Good;

public class Bike extends Good {
    private Brand brand;
    private TypeBike type;
    private int frameSize;

    public Bike() { }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TypeBike getType() {
        return type;
    }

    public void setType(TypeBike type) {
        this.type = type;
    }

    public int getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }
}


