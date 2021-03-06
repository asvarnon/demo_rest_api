package basic_rest_api_challenge.demo_rest_api.ControllersTests;


import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.Services.PersonService;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import org.joda.time.LocalDate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {


        Job job1 = new Job("Sales Rep", 55000);
        Job job2 = new Job("HR Rep", 65000);

//        Person person1 = new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1);
//        Person person2 = new Person("Bob", (short) 25, LocalDate.parse("2018-10-03"), LocalDate.now(), job1);
//        Person person3 = new Person("Moe", (short) 33, LocalDate.parse("2013-08-15"), LocalDate.now(), job2);



    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void getPersonsTestEquals(){
        when(personRepository.findAll()).thenReturn(Stream.of(
                new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1),
                new Person("Bob", (short) 25, LocalDate.parse("2018-10-03"), LocalDate.now(), job1),
                new Person("Moe", (short) 33, LocalDate.parse("2013-08-15"), LocalDate.now(), job2)
        ).collect(Collectors.toList()));
        assertEquals(3, personService.getPersons().size());
    }

    @Test
    public void getPersonsTestNotEquals(){
        when(personRepository.findAll()).thenReturn(Stream.of(
                new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1),
                new Person("Bob", (short) 25, LocalDate.parse("2018-10-03"), LocalDate.now(), job1),
                new Person("Moe", (short) 33, LocalDate.parse("2013-08-15"), LocalDate.now(), job2)
        ).collect(Collectors.toList()));
        assertNotEquals(-2, personService.getPersons().size());
        assertNotEquals(10.1, personService.getPersons().size());
        assertNotEquals(2, personService.getPersons().size());
    }

    @Test
    public void getPersonsByNameTestEquals(){
        String name = "Joe";
        when(personRepository.findByName(name)).thenReturn(Stream.of(
                new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1)
        ).collect(Collectors.toList()));
        assertEquals(1, personService.getPersonsByName(name).size());
        assertEquals("Joe", personService.getPersonsByName(name).get(0).getName());
        assertEquals(30, (long) personService.getPersonsByName(name).get(0).getAge());
        assertEquals("Sales Rep", personService.getPersonsByName(name).get(0).getJob().getJobTitle());
        assertEquals("2015-04-23", personService.getPersonsByName(name).get(0).getDateJoined().toString());
    }

    @Test
    public void getPersonsByNameTestNotEquals(){
        String name = "Joe";
        when(personRepository.findByName(name)).thenReturn(Stream.of(
                new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1)
        ).collect(Collectors.toList()));
        assertNotEquals("joe", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals("JOE", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals(2, personService.getPersonsByName(name).size());
        assertNotEquals(-4, personService.getPersonsByName(name).size());
        assertNotEquals(2.0001, personService.getPersonsByName(name).size());

        assertNotEquals(40, (long) personService.getPersonsByName(name).get(0).getAge());
        assertNotEquals("HR Rep", personService.getPersonsByName(name).get(0).getJob().getJobTitle());
        assertNotEquals("2014-04-23", personService.getPersonsByName(name).get(0).getDateJoined().toString());

    }

    @Test
    public void savePersonTest(){
        Person person = new Person("Jimmy",(short) 40, LocalDate.parse("2010-04-01"), LocalDate.now(), job2);
        when(personRepository.save(person)).thenReturn(person);
        assertEquals(person, personService.addPerson(person));
    }

    @Test
    public void deletePersonTest(){
        Person person = new Person("Jimmy",(short) 40, LocalDate.parse("2010-04-01"), LocalDate.now(), job2);
        personService.deletePerson(person);
        verify(personRepository, times(1)).delete(person);
    }


}
