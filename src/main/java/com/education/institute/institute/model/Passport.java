package com.education.institute.institute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javassist.SerialVersionUID;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Passport implements Serializable {

    private static final long serialVersionUID = -764285835790074939L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    @JsonIgnore
    private Student student;
}
