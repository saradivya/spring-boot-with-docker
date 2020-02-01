package com.esms.controller;

import com.esms.model.Learn;
import com.esms.repository.LearningRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/esms")
@RestController
public class InitialController {

    @Autowired
    private LearningRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(InitialController.class);

@GetMapping("/api/start")
public String startup(){
    repository.save(new Learn("java01", "Java")).subscribe(result -> {logger.info("Saved Successfully with result" + result);});
    repository.save(new Learn("C++01", "C++")).subscribe();
    return "Working Perfectly";
    }
}
