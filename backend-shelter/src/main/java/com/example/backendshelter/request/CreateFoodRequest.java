package com.example.backendshelter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateFoodRequest {
    private Brand brand;

    @Size(max = 255, message = "Description is too large")
    private String description;
}
