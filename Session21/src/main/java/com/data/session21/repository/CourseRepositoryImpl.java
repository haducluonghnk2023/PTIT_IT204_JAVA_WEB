package com.data.session21.repository;

import com.data.session21.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.openSession();
        List<Course> courses = session.createQuery("from Course", Course.class).getResultList();
        session.close();
        return courses;
    }

    @Override
    public Course findById(int id) {
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public Course save(Course course) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(course);
        session.getTransaction().commit();
        session.close();
        return course;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = session.get(Course.class, id);

        if (course != null && course.getStudents() != null && !course.getStudents().isEmpty()) {
            session.close();
            throw new IllegalStateException("Không thể xóa khóa học vì đang có sinh viên tham gia.");
        }

        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Course findByName(String name) {
        Session session = sessionFactory.openSession();
        Course course = session.createQuery("from Course where name = :name", Course.class)
                .setParameter("name", name)
                .uniqueResult();
        session.close();
        return course;
    }

    @Override
    public boolean isDuplicateName(String name, Integer currentId) {
        Course course = findByName(name);
        if (course == null) {
            return false;
        }

        if (currentId == null) {
            return true;
        }

        return !course.getId().equals(currentId);
    }

    @Override
    public List<Course> findByIds(List<Integer> ids) {
        Session session = sessionFactory.openSession();
        List<Course> courses = session.createQuery("from Course where id in :ids", Course.class)
                .setParameter("ids", ids)
                .getResultList();
        session.close();
        return courses;
    }

}
