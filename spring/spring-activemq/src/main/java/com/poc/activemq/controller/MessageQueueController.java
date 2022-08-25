package com.poc.activemq.controller;

import com.poc.activemq.consumer.JMSMessageListener;
import com.poc.activemq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageQueueController {

    @Value("${topic.q}")
    private String topic;

    @Value("${message.q}")
    private String normalQ;

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    @Autowired
    private JmsTemplate jmsMessageTemplate;

    @Autowired
    private JMSMessageListener receiver;

    @PostMapping(value = "/mq/topic")
    public Employee topicSender(@RequestBody Employee employee) {
        try {
            log.info("Send message to topic: " + topic);
            jmsTopicTemplate.convertAndSend(topic, employee);
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
        return employee;
    }

    @GetMapping(value="/mq/topic/read")
    public void readTopicMessage() throws InterruptedException {
        Employee employee = (Employee) jmsTopicTemplate.receiveAndConvert(topic);
        log.info("Reading from topic: "+ employee.toString());
    }

    @PostMapping(value="/mq/message")
    public Employee normalSender(@RequestBody Employee employee){
        try{
            log.info("Send message to queue: "+ normalQ);
            jmsMessageTemplate.convertAndSend(normalQ, employee);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
        return employee;
    }

    // to test this endpoint, comment out JMSMessageListener listener
    @GetMapping(value="/mq/message/read")
    public Employee readMessage() throws InterruptedException {
        Employee employee = (Employee) jmsMessageTemplate.receiveAndConvert(normalQ);
        log.info("Reading from queue: "+ employee.toString());
        return employee;
    }



}
