package experiments.rabbit.pizza.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PizzaOrderDto implements Serializable {

    private Long pizzaId;

}
