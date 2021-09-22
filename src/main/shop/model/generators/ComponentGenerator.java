package model.generators;

import model.good.component.Component;
import model.good.component.TypeComponent;

import java.util.Random;

public class ComponentGenerator {
    public static Component generate() {
        Random random = new Random();
        Component component = new Component();
        component.setType(TypeComponent.values()[random.nextInt(TypeComponent.values().length)]);
        component.setPrice(random.nextInt(100) + 15);
        return component;
    }
}
