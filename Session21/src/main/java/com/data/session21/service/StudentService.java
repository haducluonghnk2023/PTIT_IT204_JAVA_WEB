package com.data.session21.service;

import com.data.session21.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll(int page, int size);
    List<Student> findAlls();
    Student findById(int id);
    Student save(Student student);
    void deleteById(int id);
    List<Student> findByName(String name);
}
