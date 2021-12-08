package main.model.good.accessory;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.good.Good;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Bike")
public class Accessory extends Good {

    @Column()
    private TypeAccessory typeAccessory;

    @Override
    public String toString() {
        return "Accessory{" + "typeAccessory=" + typeAccessory + '}';
    }
}
