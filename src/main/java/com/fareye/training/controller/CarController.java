package com.fareye.training.controller;

import com.fareye.training.model.Car;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CarController {
    @GetMapping("/car")
    public String cardata(){
        Car car = new Car();
        car.setId(1);
        car.setName("Volvo");
        car.setModel("X10");

        return car.toString();
    }

    @PostMapping
    public String createCar(@RequestBody @Valid Car car, BindingResult bindingResult){
        bindingResult.hasErrors();
        return car.toString();
    }
}
