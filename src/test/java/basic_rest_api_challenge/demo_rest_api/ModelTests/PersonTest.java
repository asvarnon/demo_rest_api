package basic_rest_api_challenge.demo_rest_api.ModelTests;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.time.*;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person = new Person("Phil", (short) 65, LocalDate.parse("2011-01-01"), LocalDate.now(), jobRepository.findByJobTitleEquals("CEO"));

    @Before
    public void setUp(){
        LocalDate date = LocalDate.now();
        this.person.setName("Joe");
        this.person.setAge((short) 30);
        this.person.setDateJoined(LocalDate.parse("2021-01-11"));
        this.person.setDateUpdated(date);
    }

    @Test
    public void testIfPersonIsNull(){
        Person person = new Person("Phil", (short) 65, LocalDate.parse("2011-01-01"), LocalDate.now(), jobRepository.findByJobTitleEquals("CEO"));
        assertNotNull(person);
    }


    @Test
    public void testPersonName(){
        String actual = person.getName();
        List<String> names = new ArrayList<>();
        names.add("joe");
        names.add("Bill");
        names.add("Paul");
        names.add("JoE");
        for (String expected : names){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonAge(){
        Short actual = person.getAge();
        List<Short> ages = new ArrayList<>();
        ages.add((short) 20);
        ages.add((short) 35);
        ages.add((short) 40);
        for (Short expected : ages){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonDateJoined(){
        LocalDate actual = person.getDateJoined();
        List<LocalDate> datesJoined = new ArrayList<>();
        datesJoined.add(LocalDate.parse("2021-03-11"));
        datesJoined.add(LocalDate.parse("2022-04-15"));
        datesJoined.add(LocalDate.parse("2021-03-04"));
        datesJoined.add(LocalDate.parse("2021-11-25"));
        for (LocalDate expected : datesJoined){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonDateUpdated(){
        LocalDate actual = person.getDateUpdated();
        List<LocalDate> datesUpdated = new ArrayList<>();
        datesUpdated.add(LocalDate.parse("2021-03-11"));
        datesUpdated.add(LocalDate.parse("2021-02-24"));
        datesUpdated.add(LocalDate.now().plusDays(10));
        datesUpdated.add(LocalDate.parse("2021-11-11"));
        for (LocalDate expected : datesUpdated){
            assertNotEquals(expected, actual);
        }
    }



}
