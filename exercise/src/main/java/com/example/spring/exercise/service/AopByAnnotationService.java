package com.example.spring.exercise.service;

import com.example.spring.exercise.aop.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AopByAnnotationService {
    private Logger logger = LoggerFactory.getLogger(AopByAnnotationService.class);
    @Action(name = "add操作")
    public void add() {
        logger.info("执行add方法");
    }
}