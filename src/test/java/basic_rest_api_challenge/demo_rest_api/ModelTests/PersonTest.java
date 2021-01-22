package basic_rest_api_challenge.demo_rest_api.ModelTests;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.time.*;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person = new Person();

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
        Person person = new Person();
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
        LocalDate expected = LocalDate.now();
        assertEquals(expected, actual);
    }



}
