package experiments.rabbit.pizza;

import experiments.rabbit.pizza.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final RabbitTemplate rabbitTemplate;

    public void makeOrder(OrderDto orderDto) {
        rabbitTemplate.convertAndSend(
                "exchange-pizza-order",
                "pizza-order",
                orderDto
        );
    }

}
