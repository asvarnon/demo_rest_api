package basic_rest_api_challenge.demo_rest_api.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jobTitle;

    @Column
    private double salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    @JsonBackReference
    private List<Person> jobHolders;

    public Job(){}

    public Job (long id, String jobTitle, double salary){
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolders = new ArrayList<>();
    }

    public Job (String jobTitle, double salary, List<Person> jobHolders){
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolders = jobHolders;
    }

    public Job (long id, String jobTitle, double salary, List<Person> jobHolders){
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolders = jobHolders;
    }

    public Job (String jobTitle, double salary){
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolders = new ArrayList<>();
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Person> getJobHolderList() {
        return jobHolders;
    }

    public void setJobHolders(Person jobHolder) {
        this.jobHolders.add(jobHolder);
    }
}
