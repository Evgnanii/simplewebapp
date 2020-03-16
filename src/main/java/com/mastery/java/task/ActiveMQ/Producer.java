package com.mastery.java.task.ActiveMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    Logger logger = LoggerFactory.getLogger(Producer.class);
    public void sendMessage(MyMessage message) {
        logger.info("Producer working");
        jmsTemplate.convertAndSend("UpdatesByDepartmentID", message);
        logger.info("Producer gives massage");
    }
}
