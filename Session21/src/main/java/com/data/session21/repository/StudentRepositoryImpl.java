package com.data.session21.repository;

import com.data.session21.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
        session.close();
        return students;
    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null && student.getCourses() != null && !student.getCourses().isEmpty()) {
            session.getTransaction().rollback();
            session.close();
            throw new IllegalStateException("Không thể xóa sinh viên vì đang tham gia khóa học.");
        }

        if (student != null) {
            session.delete(student);
        }

        session.getTransaction().commit();
        session.close();
    }

}
