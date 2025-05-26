package com.data.session12.repo;

import com.data.session12.model.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> findAll();
    boolean save(Student student);
    Student findById(int id);
    boolean delete(int id);
    boolean update(Student student);
}
