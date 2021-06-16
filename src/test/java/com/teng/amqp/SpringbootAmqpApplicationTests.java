package com.teng.amqp;


import com.teng.amqp.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
    AmqpAdmin amqpAdmin;

	@Test
    public void testCreateExchange(){
//	    amqpAdmin.declareExchange(new DirectExchange("AmqpAdmin.exchange"));//创建交换机
//        amqpAdmin.declareQueue(new Queue("AmqpAdmin.queue"));//创建队列
        amqpAdmin.declareBinding(new Binding("AmqpAdmin.queue", Binding.DestinationType.QUEUE,
                "AmqpAdmin.exchange","amqp.haha",null));
        System.out.println("创建完成");
    }
	@Test
	public void contextLoads() {
		Map<String,Object> map = new HashMap<>();
		map.put("msg","第一个消息");
		map.put("data", Arrays.asList("Hello World",123,false));
//		rabbitTemplate.convertAndSend("exchange.direct","teng.news",map);
		rabbitTemplate.convertAndSend("exchange.direct","teng.news",new User("年华",22,"男"));
	}

	@Test
	public void reciver(){
        Object o = rabbitTemplate.receiveAndConvert("teng.news");
        System.out.println(o.getClass());
        System.out.println("o = " + o.toString());
    }

    @Test
    public void testFanout(){
	    rabbitTemplate.convertAndSend("exchange.fanout","",new User("张三",18,"女"));
    }

}
