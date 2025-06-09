package com.data.session21.repository;

import com.data.session21.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();
    Course findById(int id);
    Course save(Course course);
    void deleteById(int id);
    Course findByName(String name);
    boolean isDuplicateName(String name, Integer currentId);
    List<Course> findByIds(List<Integer> ids);
}
