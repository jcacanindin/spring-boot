package ph.homecredit.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.homecredit.exam.entity.Person;
import ph.homecredit.exam.exception.PersonException;
import ph.homecredit.exam.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    /**
     * This should insert to an h2 database
     *
     * @param person person object to create
     * @return created person
     */
    @Override
    public Person createPerson(Person person) throws PersonException {
        String alphabetRegex = "^[a-zA-Z]*$";
        
        if(person.getFirstName() == null || person.getLastName() == null || person.getAge() == null || person.getEmail() == null)
            throw new PersonException("Person contains a null value, please try again.");

        if(!person.getFirstName().matches(alphabetRegex) || !person.getLastName().matches(alphabetRegex))
            throw new PersonException("Person's names should only contain alphabets, please try again.");
        
        if(person.getMiddleName() != null && !person.getMiddleName().matches(alphabetRegex))
            throw new PersonException("Person's names should only contain alphabets, please try again.");

        if(!person.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new PersonException("Person's email is not valid, please try again.");

        person.setCreated_Date(LocalDateTime.now());
        person.setLast_Modified_Date(LocalDateTime.now());
        personRepository.save(person);

        return person;
    }

    /**
     * This should update an existing entity on an h2 database
     *
     * @param id person's id on the database
     * @param person updated person object to update the entity on the database
     * @return updated person
     */
    @Override
    public Person updatePerson(Long id, Person person) {
        Optional<Person> personFound = personRepository.findById(id);
        person.setLast_Modified_Date(LocalDateTime.now());
        
        if(personFound.isPresent()){
            Person newPerson = personFound.get();
            LocalDateTime createdDate = newPerson.getCreated_Date();
            
            person.setId(newPerson.getId());
            person.setCreated_Date(createdDate);
            
            newPerson.setId(person.getId());
            newPerson.setFirstName(person.getFirstName());
            newPerson.setMiddleName(person.getMiddleName());
            newPerson.setLastName(person.getLastName());
            newPerson.setAge(person.getAge());
            newPerson.setEmail(person.getEmail());
            newPerson.setCreated_Date(person.getCreated_Date());
            newPerson.setLast_Modified_Date(person.getLast_Modified_Date());
            
            personRepository.save(newPerson);
        }
            
        
        return person;
    }

    /**
     * @param id person's id on the database
     * @return person's id on the database
     */
    @Override
    public Long deletePerson(Long id) {
        Optional<Person> personToBeDeleted = personRepository.findById(id);
        
        if(personToBeDeleted.isPresent())
            personRepository.deleteById(id);
        
        return id;
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

}
