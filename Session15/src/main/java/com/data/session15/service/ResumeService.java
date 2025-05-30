package com.data.session15.service;

import com.data.session15.dto.Resume;

import java.util.List;
import java.util.Optional;

public interface ResumeService {
    List<Resume> findAll();
    Resume findById(Long id);
    boolean save(Resume resume);
    boolean update(Long id, Resume resume);
    boolean delete(Long id);
}
