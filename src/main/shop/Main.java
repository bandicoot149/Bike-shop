import com.fasterxml.jackson.core.JsonProcessingException;
import model.Promotion;
import model.Shop;
import model.generators.ShopGenerator;
import model.good.Good;
import model.good.accessory.Accessory;
import model.good.bike.Bike;
import model.good.component.Component;
import model.stream.MyFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ShopGenerator.generate(10, 10, 10, 10);
        MyFileReader reader = new MyFileReader(){};
        List<Bike> bikes = reader.readGoods("src/main/resources/bikes.json", Bike.class);
        List<Accessory> accessories = reader.readGoods("src/main/resources/accessories.json", Accessory.class);
        List<Component> components = reader.readGoods("src/main/resources/components.json", Component.class);
        List<Promotion> promotions = reader.readPromotions("src/main/resources/promotions.json");
        Shop shop = new Shop(100, promotions, bikes, accessories, components);
    }
}
