package com.poc.activemq.consumer;

import com.poc.activemq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Slf4j
@Component
public class JMSMessageListener implements MessageListener {

    @Override
    @JmsListener(destination = "${message.q}", containerFactory = "messageListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Employee employee = (Employee) objectMessage.getObject();
            //do additional processing
            log.info("Received Message: " + employee.toString());
        } catch (Exception e) {
            log.error("Received Exception while processing message: " + e);
        }
    }
}
