package com.example.delayed_msg.consumer;

import com.example.delayed_msg.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/6/10
 **/
@Component
public class DelayedConsumer {

  private Logger logger = LoggerFactory.getLogger(DelayedConsumer.class.getName());

  @RabbitListener(queues = RabbitConfig.MY_DELAYED_MSG_QUEUE)
  public void handleMsg(String msg) {
    logger.info("msg=>{}", msg);
  }
}
