package basic_rest_api_challenge.demo_rest_api.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Short age;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateJoined;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateUpdated;

    @ManyToOne
    @JoinColumn (name = "job_id")
    @JsonManagedReference
    private Job job;

    public Person(long id, String name, Short age, LocalDate dateJoined, LocalDate dateUpdated, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }
    public Person(String name, Short age, LocalDate dateJoined, LocalDate dateUpdated, Job job) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }

    public Person(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
