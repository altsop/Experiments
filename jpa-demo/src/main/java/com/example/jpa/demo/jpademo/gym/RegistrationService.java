package com.example.jpa.demo.jpademo.gym;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public UUID register(RegistrationRequest registrationRequest) {
        Customer customer = new Customer();
        customer.setAge(registrationRequest.getAge());
        customer.setName(registrationRequest.getName());

        registrationRepository.save(customer);
        return customer.getUuid();
    }

    public Iterable<Customer> findCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return registrationRepository.findAll(pageable);
    }

    public Customer requireClient(String uuid) {
        return registrationRepository.findByUuid(UUID.fromString(uuid));
    }
}
