package basic_rest_api_challenge.demo_rest_api.ControllersTests;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.Services.JobService;
import basic_rest_api_challenge.demo_rest_api.repos.JobRepository;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.joda.time.LocalTime.now;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JobControllerTest {

    @Autowired
    private JobService jobService;

    @MockBean
    private JobRepository jobRepository;

    @Test
    public void getJobsTestEquals(){
        when(jobRepository.findAll()).thenReturn(Stream.of(
                new Job("Sales Rep", 55000),
                new Job("HR Rep", 65000)
        ).collect(Collectors.toList()));
        assertEquals(2, jobService.getJobs().size());
        assertEquals("HR Rep", jobService.getJobs().get(1).getJobTitle());
        assertEquals(65000, jobService.getJobs().get(1).getSalary(), 0);
    }

    @Test
    public void getJobsTestNotEquals(){
        when(jobRepository.findAll()).thenReturn(Stream.of(
                new Job("Sales Rep", 55000),
                new Job("HR Rep", 65000)
        ).collect(Collectors.toList()));
        assertNotEquals(3, jobService.getJobs().size());
        assertNotEquals(-1, jobService.getJobs().size());
        assertNotEquals(2.0001, jobService.getJobs().size());
    }

    @Test
    public void addJobEquals(){
        Job job = new Job("CEO", 100000);
        when(jobRepository.save(job)).thenReturn(job);
        assertEquals(job, jobService.addJob(job));
        verify(jobRepository, times(1)).save(job);
    }

    @Test
    public void deleteJobVerify(){
        Job job = new Job("CEO", 100000);
        jobService.deleteJob(job);
        verify(jobRepository, times(1)).delete(job);
    }

    //WIP
    //Need to understand why ID has to be hardcoded instead of allowing auto increment
    //Currently unsure of how to properly test
    @Test
    public void getJobByIDEquals(){
        when(jobRepository.findAll()).thenReturn(Stream.of(
                new Job(1,"CEO", 100000),
                new Job(2,"Salesperson", 25000)
        ).collect(Collectors.toList()));
        for (Job index: jobRepository.findAll()){
            System.err.println(index.getId() + " " + index.getJobTitle());
        }
    }

    @Test
    public void jobHoldersListEquals(){
        List<Person> jobHolders = new ArrayList<>();
        Job job = new Job("CEO", 100000, jobHolders);
        Person person = new Person("Bob",(short) 35, LocalDate.parse("2011-01-01"),LocalDate.now(), job);
        jobHolders.add(person);

        assertEquals(person, job.getJobHolderList().get(0));
    }


}
