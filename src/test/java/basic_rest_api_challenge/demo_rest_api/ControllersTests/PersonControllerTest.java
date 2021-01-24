package basic_rest_api_challenge.demo_rest_api.ControllersTests;


import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import org.junit.Before;

import java.time.LocalDate;

public class PersonControllerTest {

    @Before
    public void setUp(){
        Job job1 = new Job("Sales Rep", 55000);
        Job job2 = new Job("HR Rep", 65000);

        Person person1 = new Person("Joe", (short) 30, LocalDate.parse("2015-04-23"), LocalDate.now(), job1);
        Person person2 = new Person("Bob", (short) 25, LocalDate.parse("2018-10-03"), LocalDate.now(), job1);
        Person person3 = new Person("Moe", (short) 33, LocalDate.parse("2013-08-15"), LocalDate.now(), job2);
    }

}
