package main.model.good.component;

import main.model.good.Good;

public class Component extends Good {
    private TypeComponent type;

    public TypeComponent getType() {
        return type;
    }

    public void setType(TypeComponent type) {
        this.type = type;
    }
}
