package basic_rest_api_challenge.demo_rest_api.Controllers;

import basic_rest_api_challenge.demo_rest_api.Exception.ResourceNotFoundException;
import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Services.ExceptionService;
import basic_rest_api_challenge.demo_rest_api.Services.JobService;
import basic_rest_api_challenge.demo_rest_api.Services.SeedListService;
import basic_rest_api_challenge.demo_rest_api.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
public class JobController implements Specification<Job> {

    @Autowired
    private SeedListService seedListService;

    @Autowired
    private ExceptionService exceptionService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    //Start
    @GetMapping("")
    public void start(){
        seedListService.jobSeedList();
        seedListService.personSeedList();
    }

    //createJob
    @PostMapping("/job")
    public Job createJob(@RequestBody Job job){
        return jobService.addJob(job);
    }

    //Show Job(s)
    @GetMapping(value = "/jobs")
    public List<Job> getAllJobs(){
        return jobService.getJobs();
    }

    //get Job by Id
    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Job job = jobService.getJob(id);
        exceptionService.checkJobIsNull(job);
        return ResponseEntity.ok().body(job);
    }

    //update Job
    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") long id, @RequestBody Job jobDetails) throws ResourceNotFoundException{
        Job job = jobService.getJob(id);
        exceptionService.checkJobIsNull(job);

        job.setJobTitle(jobDetails.getJobTitle());
        job.setSalary(jobDetails.getSalary());
        jobRepository.save(job);
        return ResponseEntity.ok().body(job);
    }

    //deleteJob
    @DeleteMapping("/job/{id}")
    public ResponseEntity<Job> deleteJob(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Job job = jobService.getJob(id);
        exceptionService.checkJobIsNull(job);
        jobService.deleteJob(job);
        return ResponseEntity.ok().build();
    }


    @Override
    public Specification<Job> and(Specification<Job> other) {
        return null;
    }

    @Override
    public Specification<Job> or(Specification<Job> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
