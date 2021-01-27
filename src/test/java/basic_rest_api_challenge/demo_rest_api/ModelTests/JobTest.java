package basic_rest_api_challenge.demo_rest_api.ModelTests;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import org.junit.Before;
import org.junit.Test;

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JobTest {

    private Job job = new Job("SalesRep", 55000);
    private final Person person1 = new Person("Joe", (short) 30, LocalDate.parse("2012-11-21"), LocalDate.now(), job);
    private final Person person2 = new Person("Bob", (short) 43, LocalDate.parse("2003-05-18"), LocalDate.now(), job);


    @Test
    public void testIfJobIsNull(){
        assertNotNull(this.job);
    }

    @Test
    public void testJobTitle(){
        String actual = this.job.getJobTitle();
        List<String> jobTitles = new ArrayList<>();
        jobTitles.add("IT_Supervisor");
        jobTitles.add("Sales_Supervisor");
        jobTitles.add("HR_Supervisor");
        jobTitles.add("Associate");
        jobTitles.add("salesRep");
        jobTitles.add("Salesrep");
        jobTitles.add("salesrep");
        for(String expected : jobTitles){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testJobSalary(){
        double actual = this.job.getSalary();
        double expected = 55000;
        assertEquals(expected, actual, 0);
        System.out.println("Success with no decimals");

        expected = 55000.00;
        assertEquals(expected, actual, 0);
        System.out.println("Success with decimals");
    }

    @Test
    public void testJobSalariesNotEquals(){
        double actual = this.job.getSalary();
        ArrayList<Double> salaries = new ArrayList<>();
        salaries.add((double) 260);
        salaries.add((double) 476789020);
        salaries.add(55000.1);
        salaries.add(55000.0001);
        salaries.add(55000.9999);
        salaries.add(-55000.0001);
        salaries.add((double) -55000);
        for(double expected : salaries){
            assertNotEquals(expected, actual);
        }
    }


    @Before
    public void setUp(){
        this.job.setJobHolders(person1);
        this.job.setJobHolders(person2);
    }


    @Test
    public void testIfJobHoldersEquals(){
        List<Person> actual = this.job.getJobHolderList();
        List<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);

        assertNotNull(person1);
        System.out.println("person 1 exists");

        assertNotNull(person2);
        System.out.println("person 2 exists");

        System.out.println("equals Test");
        assertEquals(expected, actual);

        System.out.println("equals success");
    }

    @Test
    public void testIfJobHoldersNotEquals(){
        List<Person> actual = this.job.getJobHolderList();

        List<Person> expected = new ArrayList<>();

        assertNotEquals(expected, actual);
        System.out.println("Current list does not equal empty list");

        expected.add(person2);
        expected.add(person1);
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

        assertNotEquals(expected, actual);
        System.out.println("not equal if different order");
    }


}
