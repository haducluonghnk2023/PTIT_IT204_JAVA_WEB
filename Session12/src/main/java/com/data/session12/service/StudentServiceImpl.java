package com.data.session12.service;

import com.data.session12.model.Student;
import com.data.session12.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return studentRepo.delete(id);
    }

    @Override
    public boolean update(Student student) {
        return studentRepo.update(student);
    }
}
