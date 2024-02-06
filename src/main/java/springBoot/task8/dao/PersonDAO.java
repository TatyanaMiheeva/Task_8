package springBoot.task8.dao;


import springBoot.task8.model.Person;

import java.util.List;

public interface PersonDAO {

    void savePerson(Person person);

    List<Person> getAllPersons();

    Person getPersonById(Long id);

    void update(Long id, Person person);

    void delete(Long id);
}
