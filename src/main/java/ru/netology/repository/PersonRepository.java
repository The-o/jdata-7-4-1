package ru.netology.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.netology.entity.Person;
import ru.netology.entity.PersonKey;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonKey> {

    public List<Person> findByCityIgnoreCase(String city);
    public List<Person> findByAgeLessThanOrderByAge(int age);
    public Optional<Person> findByNameAndSurname(String name, String surname);

}
