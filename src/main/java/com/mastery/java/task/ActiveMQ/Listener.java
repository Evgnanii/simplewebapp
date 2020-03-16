package com.mastery.java.task.ActiveMQ;

import com.mastery.java.task.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {
    @Autowired
    EmployeeService employeeService;
    Logger logger = LoggerFactory.getLogger(Listener.class);

    @JmsListener(destination = "UpdatesByDepartmentID")
    public void receiveMessage(MyMessage message) {
        logger.info("Listener take message "+ message.toString());
        employeeService.updateTitlesByDepartmentId(message.getId(), message.getTitle());
        logger.info("Listener gives message to service "+ message.toString());
    }
}
