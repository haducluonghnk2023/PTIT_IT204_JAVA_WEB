package com.data.session21.service;

import com.data.session21.entity.Course;
import com.data.session21.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public boolean isDuplicateName(String name, Integer currentId) {
        return courseRepository.isDuplicateName(name, currentId);
    }

    @Override
    public List<Course> findByIds(List<Integer> ids) {
        return courseRepository.findByIds(ids);
    }
}
