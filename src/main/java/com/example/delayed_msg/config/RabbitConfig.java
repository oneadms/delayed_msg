package com.example.delayed_msg.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/6/10
 **/
@Configuration
public class RabbitConfig {

    public static final String MY_DELAYED_MSG_QUEUE="my_delayed_msg_queue";
    public static final String MY_DELAYED_MSG_EXCHANGE = "my_delayed_msg_exchange";
//    自定义交换机的类型，这个值是固定的
    public static final String MY_DELAYED_MSG_EXCHANGE_TYPE="x-delayed-message";
@Bean
    Queue delayedQueue() {
        return new Queue(MY_DELAYED_MSG_QUEUE, true, false, false);
    }

    @Bean
    CustomExchange delayedExchange() {
        Map<String, Object> args = new HashMap<>();
//        配置当前交换机类型为直连交换机
        args.put("x-delayed-type", "direct");
        return new CustomExchange(MY_DELAYED_MSG_EXCHANGE, MY_DELAYED_MSG_EXCHANGE_TYPE, true,
            false,args);
    }
    @Bean
    Binding delayBinding() {
        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(MY_DELAYED_MSG_QUEUE)
            .noargs();
    }
}
