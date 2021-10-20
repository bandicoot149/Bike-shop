package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import main.model.Customer;
import main.model.Promotion;
import main.model.Shop;
import main.model.generators.CustomerGenerator;
import main.model.generators.ShopGenerator;
import main.model.good.accessory.Accessory;
import main.model.good.bike.Bike;
import main.model.good.component.Component;
import main.model.stream.MyFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ShopGenerator.generate(100, 20, 10, 3);
        MyFileReader reader = new MyFileReader(){};
        List<Bike> bikes = reader.readGoods("goods/bikes.json", Bike.class);
        List<Accessory> accessories = reader.readGoods("goods/accessories.json", Accessory.class);
        List<Component> components = reader.readGoods("goods/components.json", Component.class);
        List<Promotion> promotions = reader.readPromotions("goods/promotions.json");
        Shop shop = new Shop(100, promotions, bikes, accessories, components);

        List<Customer> customers = CustomerGenerator.generate(15);
        for (Customer customer: customers) {
            customer.chooseBike(bikes);
            customer.chooseComponents(components);
            customer.chooseAccessories(accessories);
        }
        for (Customer customer: customers) {
            customer.buySelectedGoods();
        }
        shop.makeStatistics();
    }
}
