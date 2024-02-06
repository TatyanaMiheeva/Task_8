package springBoot.task8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.task8.dao.PersonDAO;
import springBoot.task8.model.Person;


import java.util.Comparator;
import java.util.List;


@Service
public class PersonServiceImp implements PersonService {
    PersonDAO personDAO;

    @Autowired
    public PersonServiceImp(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons().stream().sorted(Comparator.comparing(Person::getName)).toList();
    }

    @Override
    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id);
    }

    @Override
    public void update(Long id, Person person) {
        personDAO.update(id, person);
    }

    @Override
    public void delete(Long id) {
        personDAO.delete(id);
    }

}
