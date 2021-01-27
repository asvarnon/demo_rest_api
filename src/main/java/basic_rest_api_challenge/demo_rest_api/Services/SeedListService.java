package basic_rest_api_challenge.demo_rest_api.Services;

import basic_rest_api_challenge.demo_rest_api.Models.Job;
import basic_rest_api_challenge.demo_rest_api.Models.Person;
import basic_rest_api_challenge.demo_rest_api.repos.JobRepository;
import basic_rest_api_challenge.demo_rest_api.repos.PersonRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedListService {
    @Autowired
    private PersonRepository personDao;

    @Autowired
    private JobRepository jobRepository;

    public List<Job> jobSeedList(){
        if (jobRepository.findAll().size() == 0) {
            Job firstJob = new Job("CEO", 100000);
            Job secondJob = new Job("Salesperson", 25000);
            jobRepository.save(firstJob);
            jobRepository.save(secondJob);
        }
        return jobRepository.findAll();
    }

    public List<Person> personSeedList(){
        if (personDao.findAll().size() == 0){
            Person firstPerson = new Person("Phil", (short) 65, LocalDate.parse("2011-01-01"),LocalDate.now(), jobRepository.findByJobTitleEquals("CEO"));
            Person secondPerson = new Person("Bob", (short) 35, LocalDate.parse("2020-01-01"),LocalDate.now() , jobRepository.findByJobTitleEquals("Salesperson"));
            Person thirdPerson = new Person("Jack", (short) 25, LocalDate.parse("2021-01-01"),LocalDate.now() , jobRepository.findByJobTitleEquals("Salesperson"));
            personDao.save(firstPerson);
            personDao.save(secondPerson);
            personDao.save(thirdPerson);
        }
        return personDao.findAll();
    }
}
