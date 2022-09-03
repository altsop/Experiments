package experiments.rabbit.pizza;

import experiments.rabbit.pizza.domain.PizzaOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("pizza/order")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public void makeOrder(@RequestBody PizzaOrderDto pizzaOrderDto) {
        pizzaService.makeOrder(pizzaOrderDto);
    }

}
