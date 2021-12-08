package main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.good.Good;
import main.model.good.GoodStats;
import main.model.good.accessory.Accessory;
import main.model.good.accessory.TypeAccessory;
import main.model.good.bike.Bike;
import main.model.good.bike.TypeBike;
import main.model.good.component.Component;
import main.model.good.component.TypeComponent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column()
    public String name;

    @Column()
    private double balance;

    @OneToMany()
    private List<Good> shoppingCart = new ArrayList<>();

    @OneToMany()
    private List<Good> purchasedGoods = new ArrayList<>();

    @Column()
    private TypeBike neededTypeBike;

    @Column()
    private int neededMinFrameSizeBike;

    @Column()
    private int neededMaxFrameSizeBike;

    @Column()
    private TypeAccessory neededAccessory;

    @Column()
    private TypeComponent neededComponent;

    @Override
    public String toString() {
        return "Customer{" +
                "name=" + name +
                ", balance='" + balance + '\'' +
                ", neededTypeBike='" + neededTypeBike + '\'' +
                ", neededMinFrameSizeBike='" + neededMinFrameSizeBike + '\'' +
                ", neededMaxFrameSizeBike='" + neededMaxFrameSizeBike + '\'' +
                ", neededAccessory='" + neededAccessory + '\'' +
                ", neededComponent='" + neededComponent + '\'' +
                ", shoppingCart='" + shoppingCart.size() + '\'' + // TODO: продумать вывод корзины и покупок?
                ", purchasedGoods='" + purchasedGoods.size() + '\'' +

                '}';
    }

    public void chooseBike(List<Bike> bikes) {
        for (Bike bike : bikes) {
            if ((bike.getTypeBike() == this.neededTypeBike) && (bike.getFrameSize() > this.neededMinFrameSizeBike) && (bike.getFrameSize() < this.neededMaxFrameSizeBike)) {
                if (this.balance >= bike.getPrice()) {
                    addGoodToShoppingCart(bike);
                }
            }
        }
    }

    public void chooseAccessories(List<Accessory> accessories) {
        for (Accessory accessory : accessories) {
            if ((accessory.getTypeAccessory() == neededAccessory)) {
                addGoodToShoppingCart(accessory);
            }
        }
    }

    public void chooseComponents(List<Component> components) {
        for (Component component : components) {
            if ((component.getTypeComponent() == neededComponent)) {
                addGoodToShoppingCart(component);
            }
        }
    }

    private void addGoodToShoppingCart(Good goods) {
        shoppingCart.add(goods);
    }

    public void buySelectedGoods() {
        for (Good good : shoppingCart) {
            if (balance > good.getPrice() && good.getStatus() == GoodStats.IN_STOCK && good.getClass() == Bike.class) {
                purchasedGoods.add(good);
                good.setStatus(GoodStats.SOLD_OUT);
                balance -= good.getPrice();
                System.out.println(name + " купил велосипед " + ((Bike) good).getBrand());
                break; // покупаем велосипед только один раз
            }
        }

        if (!purchasedGoods.isEmpty()) { /* Если покупатель не купил велосипед, то ему не нужны комплектующие и аксессуары*/
            for (Good good : shoppingCart) {
                if (balance > good.getPrice() && good.getStatus() == GoodStats.IN_STOCK && good.getClass() == Component.class) {
                    purchasedGoods.add(good);
                    good.setStatus(GoodStats.SOLD_OUT);
                    balance -= good.getPrice();
                    System.out.println(name + " купил компонент " + ((Component) good).getTypeComponent());
                    break;
                }
            }

            for (Good good : shoppingCart) {
                if (balance > good.getPrice() && good.getStatus() == GoodStats.IN_STOCK && good.getClass() == Accessory.class) {
                    purchasedGoods.add(good);
                    good.setStatus(GoodStats.SOLD_OUT);
                    balance -= good.getPrice();
                    System.out.println(name + " купил аксессуар " + ((Accessory) good).getTypeAccessory());
                    break;
                }
            }
        }
    }


}
