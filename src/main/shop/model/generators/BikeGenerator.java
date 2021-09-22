package model.generators;

import model.good.bike.Bike;
import model.good.bike.Brand;
import model.good.bike.TypeBike;

import java.util.Random;

public class BikeGenerator {
    public static Bike generate() {
        Random random = new Random();
        Bike bike = new Bike();
        bike.setBrand(Brand.values()[random.nextInt(Brand.values().length)]);
        bike.setType(TypeBike.values()[random.nextInt(TypeBike.values().length)]);
        int frameSize;
        double price;
        switch (bike.getType()) {
            case BMX:
                frameSize = random.nextInt(6) + 16;
                price = random.nextInt(100) + 100;
                break;
            case CHILD:
                frameSize = random.nextInt(12) + 8;
                price = random.nextInt(50) + 80;
                break;
            case WOMEN:
                frameSize = random.nextInt(14) + 14;
                price = random.nextInt(120) + 150;
                break;
            case TRACK:
                frameSize = random.nextInt(10) + 15;
                price = random.nextInt(250) + 180;
                break;
            case MOUNTAIN:
                frameSize = random.nextInt(11) + 14;
                price = random.nextInt(300) + 150;
                break;
            default:
                frameSize = 18;
                price = 120;
        }
        bike.setPrice(price);
        bike.setFrameSize(frameSize);
        return bike;
    }
}
