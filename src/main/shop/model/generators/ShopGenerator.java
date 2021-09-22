package model.generators;

import model.Promotion;
import model.Shop;
import model.good.accessory.Accessory;
import model.good.bike.Bike;
import model.good.component.Component;

import java.util.ArrayList;
import java.util.List;

public class ShopGenerator {
    public static void generate(int bikesCount, int accessoryCount, int componentsCount, int promotionCount) {
        Shop shop = new Shop();
        List<Bike> bikes = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        List<Component> components = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();
        for (int i = 0; i < bikesCount; i++) {
            bikes.add(BikeGenerator.generate());
        }
        for (int i = 0; i < accessoryCount; i++) {
            accessories.add(AccessoryGenerator.generate());
        }
        for (int i = 0; i < componentsCount; i++) {
            components.add(ComponentGenerator.generate());
        }
        for (int i = 0; i < promotionCount; i++) {
            promotions.add(PromotionGenerator.generate());
        }
        /* Тут вероятно будет реализована запись в файлы*/
    }

}
