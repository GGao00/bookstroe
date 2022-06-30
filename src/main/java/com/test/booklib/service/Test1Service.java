package com.test.booklib.service;

import com.test.booklib.entity.Test1;
import com.test.booklib.repository.Test1Repository;
import com.test.booklib.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class Test1Service {

    @Autowired
    private Test1Repository test1Repository;

    public List<Test1> findAllTest1() {
        log.info("We want to find all Test1");
        return test1Repository.findAll();
    }

    public Test1 createTest1(Test1 newTest1) {
        newTest1.setId(null);
        log.info("We want to create a Test1: {}", JsonUtil.toJsonString(newTest1));
        Optional<Test1> optionalOldTest1 = test1Repository.findByName(newTest1.getName());
        if (optionalOldTest1.isPresent()) {
            Test1 oldTest1 = optionalOldTest1.get();
            log.info("Can not to create a existed NAME Test1: {}", JsonUtil.toJsonString(oldTest1));
            return oldTest1;
        }
        newTest1 = test1Repository.save(newTest1);
        return newTest1;
    }

    public Test1 modifyTest1(Test1 newTest1) {
        log.info("We want to modify a Test1: {}", JsonUtil.toJsonString(newTest1));
        Optional<Test1> optionalOldTest1 = test1Repository.findById(newTest1.getId());
        if (optionalOldTest1.isPresent()) {
            Test1 oldTest1 = optionalOldTest1.get();
            oldTest1.setName(newTest1.getName());
            oldTest1 = test1Repository.save(oldTest1);
            log.info("We modified a Test1: {}", JsonUtil.toJsonString(oldTest1));
            return oldTest1;
        }
        return newTest1;
    }

    public void deleteTest1ByName(String name) {
        log.info("We want to delete a Test1 by Name: {}", name);
        Optional<Test1> optionalTest1 = test1Repository.findByName(name);
        if (optionalTest1.isPresent()) {
            Test1 oldTest1 = optionalTest1.get();
            test1Repository.delete(oldTest1);
            log.info("Deleted a Test1 by Name: {}", name);
        } else {
            log.info("Can not find a Test1 by Name: {}", name);
        }
    }
}
