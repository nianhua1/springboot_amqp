package com.teng.amqp.service;

import com.teng.amqp.bean.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
/**
 * @author shkstart
 * @create 2021-06-16 20:57
 */
@Service
public class UserService {

    @RabbitListener(queues = "teng.news")
    public void reciver(User user){
        System.out.println("user = " + user);
    }

    @RabbitListener(queues = "teng")
    public void reciver2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
