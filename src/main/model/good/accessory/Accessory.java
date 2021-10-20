package main.model.good.accessory;

import main.model.good.Good;

public class Accessory extends Good {
    private TypeAccessory type;

    public TypeAccessory getType() {
        return type;
    }

    public void setType(TypeAccessory type) {
        this.type = type;
    }
}
