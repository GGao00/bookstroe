package com.test.booklib.controller;

import com.test.booklib.entity.Test1;
import com.test.booklib.service.Test1Service;
import com.test.booklib.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Test1Controller {
    @Autowired
    private Test1Service test1Service;

    @PostMapping("/test1")
    public Test1 createTest1(@RequestBody Test1 test1) {
        log.info("Create Test1");
        Test1 createdTest1 = test1Service.createTest1(test1);
        log.info("Created Test1: {}", JsonUtil.toJsonString(createdTest1));
        return createdTest1;
    }

    @GetMapping("/test1")
    public List<Test1> findAllTest1() {
        log.info("Find All Test1");
        List<Test1> allTest1 = test1Service.findAllTest1();
        log.info("All Test1: {}", JsonUtil.toJsonString(allTest1));
        return allTest1;
    }

    @PutMapping("/test1")
    public Test1 modifyTest1(@RequestBody Test1 test1) {
        log.info("Modify Test1");
        Test1 modifiedTest1 = test1Service.modifyTest1(test1);
        log.info("Modified Test1: {}", JsonUtil.toJsonString(modifiedTest1));
        return modifiedTest1;
    }

    @DeleteMapping("/test1/{name}")
    public void deleteTest1(@PathVariable("name") String name) {
        log.info("Delete Test1");
        test1Service.deleteTest1ByName(name);
    }
}
