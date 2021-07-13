package com.example.spring.exercise.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class AopByMethodService {
    private Logger logger = LoggerFactory.getLogger(AopByMethodService.class);

    public void add() {
        logger.info("执行add方法");
    }
}