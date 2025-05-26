package com.data.session12.repo;

import com.data.session12.model.Status;
import com.data.session12.model.Student;
import com.data.session12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepoImpl implements  StudentRepo {
    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Student> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_all_students()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAvatar(rs.getString("avatar"));
                student.setStatus(Status.fromString(rs.getString("status")));
                list.add(student);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call insert_student(?,?,?,?,?,?,?)}");
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getPhone());
            stmt.setBoolean(4, student.isSex());
            stmt.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
            stmt.setString(6, student.getAvatar());
            stmt.setString(7, student.getStatus().toString());
            return stmt.executeUpdate() > 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_student_by_id(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAvatar(rs.getString("avatar"));
                student.setStatus(Status.fromString(rs.getString("status")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return student;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_student(?)}");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_student(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPhone());
            stmt.setBoolean(5, student.isSex());
            stmt.setDate(6, new java.sql.Date(student.getBirthday().getTime()));
            stmt.setString(7, student.getAvatar());
            stmt.setString(8, student.getStatus().toString());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }
}
