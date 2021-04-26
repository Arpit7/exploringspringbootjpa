package com.education.institute.institute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

public class Review implements Serializable {


    private static final long serialVersionUID = 4721625416733205643L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reviewDescription;

    @ManyToOne()
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    @JsonIgnore
    private Course course;
}
