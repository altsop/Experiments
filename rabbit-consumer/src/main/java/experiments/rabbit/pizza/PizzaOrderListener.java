package experiments.rabbit.pizza;

import experiments.rabbit.pizza.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        value = "queue-pizza-order"
                ),
                exchange = @Exchange(
                        name = "exchange-pizza-order"
                ),
                key = "pizza-order"
        )
)
public class PizzaOrderListener {

    @RabbitHandler
    public void handlePizzaOrder(@Payload OrderDto orderDto) {
        log.info("pizza order with id {}", orderDto.getPizzaId());
    }

}
