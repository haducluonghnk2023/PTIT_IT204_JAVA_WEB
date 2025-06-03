package com.data.session15.repository;

import com.data.session15.dto.Resume;

import java.util.List;

public interface ResumeRepository {
    List<Resume> findAll();
    Resume findById(Long id);
    boolean save(Resume resume);
    boolean update(Long id, Resume resume);
    boolean delete(Long id);
}
