package basic_rest_api_challenge.demo_rest_api.ControllersTests;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Services.JobService;
import basic_rest_api_challenge.demo_rest_api.repos.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void getJobByTitleTestEquals(){
        String searchQuery = "Rep";
        when(jobRepository.findByJobTitleLike(searchQuery)).thenReturn(Stream.of(
                new Job("Sales Rep", 55000),
                new Job("HR Rep", 65000)
        ).collect(Collectors.toList()));
        assertEquals(2, jobService.getJobsByTitle(searchQuery).size());
    }



}
