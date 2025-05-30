package com.data.session15.repository;

import com.data.session15.dto.Resume;
import com.data.session15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeRepositoryImpl implements  ResumeRepository {
    @Override
    public List<Resume> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Resume> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call GetAllResumes()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Resume resume = new Resume();
                resume.setId(rs.getLong("id"));
                resume.setFullName(rs.getString("full_name"));
                resume.setEmail(rs.getString("email"));
                resume.setPhoneNumber(rs.getString("phone_number"));
                resume.setEducation(rs.getString("education"));
                resume.setExperience(rs.getString("experience"));
                resume.setSkills(rs.getString("skills"));
                list.add(resume);

            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Resume findById(Long id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call GetResumeById(?)}");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Resume resume = new Resume();
                resume.setId(rs.getLong("id"));
                resume.setFullName(rs.getString("full_name"));
                resume.setEmail(rs.getString("email"));
                resume.setPhoneNumber(rs.getString("phone_number"));
                resume.setEducation(rs.getString("education"));
                resume.setExperience(rs.getString("experience"));
                resume.setSkills(rs.getString("skills"));
                return resume;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return null;
    }

    @Override
    public boolean save(Resume resume) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call AddResume(?,?,?,?,?,?)}");
            stmt.setString(1, resume.getFullName());
            stmt.setString(2, resume.getEmail());
            stmt.setString(3, resume.getPhoneNumber());
            stmt.setString(4, resume.getEducation());
            stmt.setString(5, resume.getExperience());
            stmt.setString(6, resume.getSkills());

            return stmt.executeUpdate() > 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean update(Long id, Resume resume) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call UpdateResume(?,?,?,?,?,?,?)}");
            stmt.setLong(1, resume.getId());
            stmt.setString(2, resume.getFullName());
            stmt.setString(3, resume.getEmail());
            stmt.setString(4, resume.getPhoneNumber());
            stmt.setString(5, resume.getEducation());
            stmt.setString(6, resume.getExperience());
            stmt.setString(7, resume.getSkills());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call DeleteResume(?)}");
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }
}
