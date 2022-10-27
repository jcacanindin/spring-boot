package ph.homecredit.exam.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.homecredit.exam.entity.Person;
import ph.homecredit.exam.exception.PersonException;

@RequestMapping("/default")
public interface PersonController {
    
    @GetMapping("/persons")
    Person getPerson(Long id);

    @PostMapping("/persons")
    Person createPerson(Person person) throws PersonException;

    @PutMapping("/persons")
    Person updatePerson(@RequestParam Long id, Person person);

    @DeleteMapping("/persons/{id}")
    Long deletePerson(@PathVariable("id") Long id);
    
    @GetMapping("/test")
    String test();
}
