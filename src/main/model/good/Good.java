package main.model.good;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "GOOD")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(precision = 3, scale = 2)
    @Type(type = "big_decimal")
    private double price;

    @Column()
    private GoodStats status = GoodStats.IN_STOCK;

    @Override
    public String toString() {
        return "Good{" +
                "price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
