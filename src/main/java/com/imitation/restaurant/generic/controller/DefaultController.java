package com.imitation.restaurant.generic.controller;

import com.imitation.restaurant.generic.Model;
import com.imitation.restaurant.generic.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public class DefaultController <T extends Model, S extends DefaultService<T, ?>> {

    @Autowired
    public S service;

    @GetMapping("/getAll")
    public Collection<T> get() {
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    public T get(@PathVariable Long id) {
        return service.findOne(id);
    }


}
