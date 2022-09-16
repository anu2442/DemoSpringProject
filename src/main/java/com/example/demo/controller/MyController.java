package com.example.demo.controller;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "L babu chimtu";

    }

    // get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    // get the single course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    // post the course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    // put the course
    @PutMapping("/courses")
    public Course putCourse(@RequestBody Course course){
        return this.courseService.putCourse(course);
    }

    // delete the course
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        this.courseService.deleteCourse(Long.parseLong(courseId));
        return;
    }
}
