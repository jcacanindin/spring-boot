package ph.homecredit.exam.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.homecredit.exam.entity.Person;
import ph.homecredit.exam.exception.PersonException;
import ph.homecredit.exam.service.PersonService;

@RestController
@RequestMapping("/homecredit/test")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;
    
    public PersonControllerImpl(PersonService personService){
        this.personService = personService;
    }

    @Override
    public Person createPerson(@RequestBody Person person) throws PersonException {
        return personService.createPerson(person);
    }

    @Override
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @Override
    public Long deletePerson(Long id) {
        return personService.deletePerson(id);
    }
    
    @Override
    public String test(){
        return "success";
    }

    @Override
    public Person getPerson(Long id) {
       return personService.getPerson(id);
    }

}
