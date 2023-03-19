package com.example.crud.subject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;


    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }


    public void addNewSubject(Subject subject) {
        Optional<Subject> subjectOptional = subjectRepository.findSubjectById(subject.getId());
        if(subjectOptional.isPresent()){
            throw new IllegalStateException("Subject already exist");
        }
        subjectRepository.save(subject);
    }

    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }
}
