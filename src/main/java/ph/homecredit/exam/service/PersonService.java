package ph.homecredit.exam.service;

import ph.homecredit.exam.entity.Person;
import ph.homecredit.exam.exception.PersonException;

public interface PersonService {

    Person createPerson(Person person) throws PersonException;

    Person updatePerson(Long id, Person person);

    Long deletePerson(Long id);
    
    Person getPerson(Long id);

}
