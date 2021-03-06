package com.example.backendshelter.controller;

import com.example.backendshelter.request.CreateFoodRequest;
import com.example.backendshelter.service.FoodService;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.time.Clock;
import java.time.LocalDateTime;

@RestController
@Validated
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @SneakyThrows
    @PostMapping("/food")
    //@ResponseStatus(HttpStatus.CREATED) //Approach number 1 of handling returned status code
    public ResponseEntity createFood(@RequestBody @Valid CreateFoodRequest request) {
        //503 -> if it is later than 8AM
        if (LocalDateTime.now(Clock.systemUTC()).isAfter(LocalDateTime.parse("2021-10-15T08:00:00.000000"))) {
            throw new ServiceNotAvailable("Service is not available today after 10AM");
        }

        return ResponseEntity.created(URI.create("/food/1")).body("Hello this is my message"); //Approach number 1 of handling returned
    }
}
