package model.generators;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Promotion;
import model.good.Good;
import model.stream.MyFileWriter;

import java.util.ArrayList;
import java.util.List;

public class ShopGenerator {
    public static void generate(int bikesCount, int accessoryCount, int componentsCount, int promotionCount) throws JsonProcessingException {
        MyFileWriter fileWriter = new MyFileWriter();
        List<Good> bikes = new ArrayList<>();
        List<Good> accessories = new ArrayList<>();
        List<Good> components = new ArrayList<>();
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

        fileWriter.writeGoods(bikes, "src/main/resources/bikes.json");
        fileWriter.writeGoods(accessories, "src/main/resources/accessories.json");
        fileWriter.writeGoods(components, "src/main/resources/components.json");
        fileWriter.writeGoods(promotions, "src/main/resources/promotions.json");
    }

}
