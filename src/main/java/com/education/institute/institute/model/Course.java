package com.education.institute.institute.model;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Cacheable
public class Course implements Serializable {

    private static final long serialVersionUID = -999124665302272831L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseName;
    @CreationTimestamp
    private LocalDateTime createTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students=new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Review> reviews=new ArrayList<>();



}
