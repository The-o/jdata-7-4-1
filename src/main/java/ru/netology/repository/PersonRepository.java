package ru.netology.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ru.netology.entity.Person;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("SELECT p FROM Person AS p WHERE LOWER(p.city) = LOWER(:city)")
            .setParameter("city", city);

        return query.getResultList();
    }
}
