package com.example.jpa.demo.jpademo.gym;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RegistrationRepository extends PagingAndSortingRepository<Customer, UUID> {

    @NonNull Customer findByUuid(UUID uuid);
}
