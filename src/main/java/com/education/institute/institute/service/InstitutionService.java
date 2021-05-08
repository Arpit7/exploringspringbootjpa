package com.education.institute.institute.service;

import com.education.institute.institute.model.Course;
import com.education.institute.institute.model.Review;
import com.education.institute.institute.repository.CourseRepository;
import com.education.institute.institute.repository.ReviewRepository;
import com.education.institute.institute.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ReviewRepository reviewRepository;


    public Optional<Course> getCourseDetails(Long course_id) {
        return courseRepository.findById(course_id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void saveReviews(Course course) {
        for (Review review : course.getReviews()) {
            review.setCourse(course);
            reviewRepository.save(review);
        }
    }

    public void deleteCourse(Long course_id) {

        Course course = courseRepository.findById(course_id).orElseThrow();
        course.getReviews().forEach(r1 -> reviewRepository.deleteById(r1.getId()));


        courseRepository.deleteById(course_id);
    }


}
