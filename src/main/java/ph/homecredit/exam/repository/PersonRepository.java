package ph.homecredit.exam.repository;

import org.springframework.data.repository.CrudRepository;
import ph.homecredit.exam.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
