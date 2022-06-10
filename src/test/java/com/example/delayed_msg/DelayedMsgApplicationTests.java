package com.example.delayed_msg;

import com.example.delayed_msg.config.RabbitConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DelayedMsgApplicationTests {

  @Test
  void contextLoads() {
  }

  @Resource
  RabbitTemplate rabbitTemplate;

  @Test
  public void test01() {
    Message message = MessageBuilder.withBody("你好,我来了".getBytes()).setHeader("x-delay", 30000).build();
    rabbitTemplate.send(RabbitConfig.MY_DELAYED_MSG_EXCHANGE, RabbitConfig.MY_DELAYED_MSG_QUEUE,
        message);
  }
}
