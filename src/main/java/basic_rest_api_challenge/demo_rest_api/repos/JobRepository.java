package basic_rest_api_challenge.demo_rest_api.repos;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findByJobTitleEquals(String jobTitle);
    Job findById(long jobId);
    List<Job> findByJobTitle(String jobTitle);
}
