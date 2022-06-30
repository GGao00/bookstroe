package com.test.booklib.repository;

import com.test.booklib.entity.Test1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Test1Repository extends JpaRepository<Test1, Long> {

    Optional<Test1> findByName(String name);

}
