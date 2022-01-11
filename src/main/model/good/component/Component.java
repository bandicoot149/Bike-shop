package main.model.good.component;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.good.Good;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Component")
public class Component extends Good {

    @Column()
    private TypeComponent typeComponent;

    @Override
    public String toString() {
        return "Component{" + "typeComponent=" + typeComponent + '}';
    }
}
