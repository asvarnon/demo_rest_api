package basic_rest_api_challenge.demo_rest_api.Controllers;

import basic_rest_api_challenge.demo_rest_api.Exception.ResourceNotFoundException;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // create get all persons api
    @GetMapping("/persons")
    public List<Person> getAllPersons(){
       return personRepository.findAll();
    }

    //create person
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    //get person by id
    @GetMapping("person/{id}")
    public @ResponseBody Person getPersonById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        if (personRepository.findAllById(id) == null){
            throw new ResourceNotFoundException("person not found");
        }
        return personRepository.findAllById(id);
    }

    //update person
    @PutMapping("/person/{id}")
    public @ResponseBody Person updatePerson(@PathVariable(value = "id") long id, @RequestBody Person personDetails) throws ResourceNotFoundException{
        if (personRepository.findAllById(id) == null){
            throw new ResourceNotFoundException("person not found");
        }

    }

    //delete person by id

}
