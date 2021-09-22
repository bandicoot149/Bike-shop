package model.good.component;

import model.good.Good;

public class Component extends Good {
    private TypeComponent type;

    public TypeComponent getType() {
        return type;
    }

    public void setType(TypeComponent type) {
        this.type = type;
    }
}
