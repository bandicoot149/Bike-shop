package main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.good.bike.Bike;
import main.model.good.bike.Brand;
import main.model.good.bike.TypeBike;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SHOP")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column()
    private Brand brand;

    @Column()
    private TypeBike typeBike;

    @Column()
    private int percent;

    @Override
    public String toString() {
        return "Promotion{" +
                "brand=" + brand +
                ", typeBike='" + typeBike + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }

    public boolean checkCompliance(Bike bike) {
        return bike.getBrand() == brand && bike.getTypeBike() == typeBike;
    }
}
