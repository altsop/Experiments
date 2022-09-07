package com.example.jpa.demo.jpademo.gym;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Sportsman, Long> {

    List<Sportsman> findByLastName(String lastName);

    Sportsman findById(long id);

}
