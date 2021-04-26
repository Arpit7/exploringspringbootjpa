package com.education.institute.institute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1874746747097951337L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentName;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport = new Passport();

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    List<Course> courses=new ArrayList<>();


}
