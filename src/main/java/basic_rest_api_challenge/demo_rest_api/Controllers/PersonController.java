package basic_rest_api_challenge.demo_rest_api.Controllers;

import basic_rest_api_challenge.demo_rest_api.Exception.ResourceNotFoundException;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.Services.ExceptionService;
import basic_rest_api_challenge.demo_rest_api.Services.PersonService;
import basic_rest_api_challenge.demo_rest_api.Services.SeedListService;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ExceptionService exceptionService;

    @Autowired
    private PersonService personService;

    @Autowired
    private SeedListService seedListService;

    //start
    @GetMapping("")
    public void start(){
        seedListService.jobSeedList();
        seedListService.personSeedList();
    }

    // create get all persons api
    @GetMapping(value = "/persons")
    public List<Person> getAllPersons(){
       return personService.getPersons();
    }

    //create person
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    //get person by id
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Person person = personService.getPerson(id);
        exceptionService.checkPersonIsNull(person);
        return ResponseEntity.ok().body(person);
    }

    //update person
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") long id, @RequestBody Person personDetails) throws ResourceNotFoundException{
        Person person = personRepository.findAllById(id);
        exceptionService.checkPersonIsNull(person);

        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        person.setJob(personDetails.getJob());
        person.setDateJoined(personDetails.getDateJoined());
        person.setDateUpdated(personDetails.getDateUpdated());
        personRepository.save(person);
        return ResponseEntity.ok().body(person);
    }

    //delete person by id
    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Person person = personRepository.findAllById(id);
        exceptionService.checkPersonIsNull(person);
        personService.deletePerson(person);
        return ResponseEntity.ok().build();
    }

}
