package main.model.generators;

import main.model.Customer;
import main.model.good.accessory.TypeAccessory;
import main.model.good.bike.TypeBike;
import main.model.good.component.TypeComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerGenerator {
    public static List<Customer> generate(int count) {
        Random random = new Random();
        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            Customer customer = new Customer();
            customer.setBalance(random.nextInt(200) + 100);
            customer.setNeededTypeBike(TypeBike.values()[random.nextInt(TypeBike.values().length)]);
            customer.setNeededMinFrameSizeBike(random.nextInt(15) + 8); // тут тоже нужен switch
            customer.setNeededMaxFrameSizeBike(customer.getNeededMinFrameSizeBike() + 5);
            customer.setNeededAccessory(TypeAccessory.values()[random.nextInt(TypeAccessory.values().length)]);
            customer.setNeededComponent(TypeComponent.values()[random.nextInt(TypeComponent.values().length)]);
            customers.add(customer);
        }
        return customers;
    }
}
