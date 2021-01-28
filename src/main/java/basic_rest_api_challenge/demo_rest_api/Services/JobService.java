package basic_rest_api_challenge.demo_rest_api.Services;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.repos.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    public Job addJob(Job job){
        return jobRepository.save(job);
    }

    public List<Job> getJobs(){
        List<Job> jobs = jobRepository.findAll();
        return jobs;
    }

    public Job getJob(long jobId){
        Job job = jobRepository.findById(jobId);
        return job;
    }

    public List<Job> getJobsByTitle(String title){
        return jobRepository.findByJobTitle(title);

    }

    public void deleteJob(Job job){
        jobRepository.delete(job);
    }

}
