package main.model.good.bike;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.good.Good;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Bike")
public class Bike extends Good {

    @Column()
    private Brand brand;

    @Column()
    private TypeBike typeBike;

    @Column()
    private int frameSize;

    @Override
    public String toString() {
        return "Bike{" +
                "brand=" + brand +
                ", typeBike='" + typeBike + '\'' +
                ", frameSize='" + frameSize + '\'' +
                '}';
    }
}


