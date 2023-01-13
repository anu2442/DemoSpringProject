package com.example.demo.services;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

//    List<Course> list;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {

//        list = new ArrayList<>();
//        list.add(new Course(145,"java","this is basics of java"));
//        list.add(new Course(4343,"Spring java","this is basics of spring java"));
    }

    @Override
    public List<Course> getCourses() {

//        return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {

//        Course course = null;
//        for (Course c:list) {
//            if (c.getId() == courseId){
//                course = c;
//                break;
//            }
//        }
//        return course;
//        return courseDao.getOne(courseId);
        List<Course> temp = courseDao.findAll();
        for (Course c :
                temp) {
            if (c.getId() == courseId) {
                return c;
            }
            }
        return new Course();
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
//        return course;

        courseDao.save(course);
        return course;
    }

    @Override
    public Course putCourse(Course course) {

//        for (Course c:list){
//            if (c.getId() == course.getId()){
//                list.remove(c);
//                list.add(course);
//                break;
//            }
//        }
//        return course;

        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {

//        for (Course course:list){
//            if (course.getId() == courseId){
//                list.remove(course);
//                break;
//            }
//        }

        courseDao.delete(courseDao.getOne(courseId));
    }
}
