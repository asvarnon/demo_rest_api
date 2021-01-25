package basic_rest_api_challenge.demo_rest_api.Services;

import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getPersons(){
        List<Person> persons = personRepository.findAll();
        System.out.println("getting data from db: " + persons);
        return persons;
    }

    public Person getPerson(long personId){
        Person person = personRepository.findById(personId);
        return person;
    }

    public List<Person> getPersonsByName(String name){
        return personRepository.findByName(name);
    }

    public void deletePerson(Person person){
        personRepository.delete(person);
    }


}
