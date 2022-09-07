package com.example.jpa.demo.jpademo.gym;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/gym/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public UUID register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }

    @GetMapping("findByPageAndSize")
    public Iterable<Customer> findByPageAndSize(@Param("page") int page, @Param("size") int size ) {
        return registrationService.findCustomers(page, size);
    }

    @GetMapping("requireClient")
    public Customer requireClient(String UUID) {
        return registrationService.requireClient(UUID);
    }

}
