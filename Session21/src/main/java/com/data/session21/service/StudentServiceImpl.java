package com.data.session21.service;

import com.data.session21.entity.Student;
import com.data.session21.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements  StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll(int page, int size) {
        return studentRepository.findAll(page, size);
    }

    @Override
    public List<Student> findAlls() {
        return studentRepository.findAlls();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        if (name == null || name.isEmpty()) {
            return studentRepository.findAll(1, 10);
        }
        return studentRepository.findByName(name);
    }
}
