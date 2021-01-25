package basic_rest_api_challenge.demo_rest_api.repos;

import basic_rest_api_challenge.demo_rest_api.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findAllById(long id);
    Person findById(long id);
    List<Person> findByName(String name);
}
