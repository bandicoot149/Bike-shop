package model.bike;

import model.Goods;

public class Bike extends Goods {
    private Brand brand;
    private TypeBike type;
    private int frameSize;

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


