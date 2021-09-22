package model.generators;

import model.Promotion;
import model.good.bike.Brand;
import model.good.bike.TypeBike;

import java.util.Random;

public class PromotionGenerator {
    public static Promotion generate() {
        Random random = new Random();
        Promotion promotion = new Promotion();
        int option = random.nextInt(2);
        switch (option) {
            case 0:
                promotion.setBrand(Brand.values()[random.nextInt(Brand.values().length)]);
                break;
            case 1:
                promotion.setTypeBike(TypeBike.values()[random.nextInt(TypeBike.values().length)]);
            default:
                promotion.setBrand(Brand.values()[random.nextInt(Brand.values().length)]);
                promotion.setTypeBike(TypeBike.values()[random.nextInt(TypeBike.values().length)]);
        }
        return promotion;
    }
}
