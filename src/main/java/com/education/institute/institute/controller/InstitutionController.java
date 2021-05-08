package com.education.institute.institute.controller;

import com.education.institute.institute.model.Course;
import com.education.institute.institute.model.Review;
import com.education.institute.institute.model.Student;
import com.education.institute.institute.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institute/courses")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/{course_id}")
    public ResponseEntity<Course> getCourseDetails(@PathVariable(name = "course_id") Long course_id)
    {
        Optional<Course> optionalCourse=institutionService.getCourseDetails(course_id);
        return ResponseEntity.of(optionalCourse);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course)
    {
       Course course1= institutionService.saveCourse(course);
       institutionService.saveReviews(course1);
       return ResponseEntity.ok(course1);
    }


    @DeleteMapping("/{course_id}")
    public void deleteCourseDetails(@PathVariable(name = "course_id") Long course_id)
    {
        institutionService.deleteCourse(course_id);
    }


}
