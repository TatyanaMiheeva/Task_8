package springBoot.task8.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springBoot.task8.model.Person;

import java.util.List;


@Repository
public class PersonDAOImp implements PersonDAO {
    @Autowired
    private EntityManager entityManager;


    @Transactional
    @Override
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public Person getPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }


    @Transactional
    @Override
    public void update(Long id, Person person) {
        Person personForUpdate = entityManager.find(Person.class, id);
        personForUpdate.setName(person.getName());
        personForUpdate.setLastname(person.getLastname());
        personForUpdate.setAge(person.getAge());
        entityManager.merge(personForUpdate);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

}
