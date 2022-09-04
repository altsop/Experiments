package experiments.rabbit.pizza;

import com.rabbitmq.client.Channel;
import experiments.rabbit.pizza.domain.PizzaOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
        ),
        ackMode = "MANUAL"
)
public class PizzaOrderListener {

    @RabbitHandler
    public void handlePizzaOrder(
            @Payload PizzaOrderDto pizzaOrderDto,
            Channel channel,
            @Header(AmqpHeaders.DELIVERY_TAG) Long tag
    ) throws IOException {
        if (pizzaOrderDto.getPizzaId() == 100) {
            // message is confirmed
            channel.basicAck(tag, false);
        } else if (pizzaOrderDto.getPizzaId() == 200) {
            // msg is just dropped
            channel.basicNack(tag, false, false);
        } else if (pizzaOrderDto.getPizzaId() == 300) {
            // endless loop. remains unacked
            channel.basicNack(tag, false, true);
        } else if (pizzaOrderDto.getPizzaId() == 0) {
            // message is just dropped
            channel.basicReject(tag, false);
        } else if (pizzaOrderDto.getPizzaId() == -1) {
            // endless loop. remains unacked
            channel.basicReject(tag, true);
        }
        log.info("pizza order with id {}", pizzaOrderDto.getPizzaId());
    }

}
