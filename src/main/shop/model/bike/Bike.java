package model.bike;

public class Bike {
    private static int ID = 0;
    private int id;
    private Brand model;
    private TypeBike type;
    private int frameSize;
    private double price;

    public Bike() {
        id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public Brand getModel() {
        return model;
    }

    public void setModel(Brand model) {
        this.model = model;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


