package model.good.accessory;

import model.good.Good;

public class Accessory extends Good {
    private TypeAccessory type;

    public TypeAccessory getType() {
        return type;
    }

    public void setType(TypeAccessory type) {
        this.type = type;
    }
}
