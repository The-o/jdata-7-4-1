package ru.netology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.entity.Person;
import ru.netology.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByCity(@RequestParam int age) {
        return service.getPersonsYoungerThan(age);
    }

    @GetMapping("/persons/by-name")
    public Person getPersonsName(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameAndSurname(name, surname).orElse(null);
    }

}
