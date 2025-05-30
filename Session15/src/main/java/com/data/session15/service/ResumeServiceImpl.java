package com.data.session15.service;

import com.data.session15.dto.Resume;
import com.data.session15.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements  ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume findById(Long id) {
        return resumeRepository.findById(id);
    }

    @Override
    public boolean save(Resume resume) {
        if (resume.getId() == null) {
            return resumeRepository.save(resume);
        } else {
            return resumeRepository.update(resume.getId(), resume);
        }
    }

    @Override
    public boolean update(Long id, Resume resume) {
        return resumeRepository.update(id, resume);
    }

    @Override
    public boolean delete(Long id) {
        return resumeRepository.delete(id);
    }

}
