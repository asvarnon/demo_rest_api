package basic_rest_api_challenge.demo_rest_api.Services;

import basic_rest_api_challenge.demo_rest_api.Exception.ResourceNotFoundException;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    @Autowired
    private PersonRepository personRepository;

    public boolean checkPersonIsNull(Person person) throws ResourceNotFoundException{
        if(person == null){
            throw new ResourceNotFoundException("Person not found");
        } else {
            return false;
        }
    }

    public boolean checkPersonIsNull(long personID) throws ResourceNotFoundException{
        Person person = personRepository.findById(personID);
        if(person == null){
            throw new ResourceNotFoundException("Person not found");
        } else {
            return false;
        }
    }


    public ResponseEntity<Person> personNotFound(Person person) throws ResourceNotFoundException {
        if (person == null){
            throw new ResourceNotFoundException("Object not found");
        }
        return ResponseEntity.ok().body(person);
    }

}
