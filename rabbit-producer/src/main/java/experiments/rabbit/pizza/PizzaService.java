package experiments.rabbit.pizza;

import experiments.rabbit.pizza.domain.PizzaOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final RabbitTemplate rabbitTemplate;

    public void makeOrder(PizzaOrderDto pizzaOrderDto) {
        rabbitTemplate.convertAndSend(
                "exchange-pizza-order",
                "pizza-order",
                pizzaOrderDto
        );
    }

}
