package com.ps.service;

import com.ps.model.Speaker;
import com.ps.repository.HibernateSpeakerRepositoryImpl;
import com.ps.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {
// A Java class implementing SpeakerService interface using HibernateSpeakerRepositoryImpl for speaker data retrieval.
private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();
    @Override
    public List<Speaker> findAll(){
    return repository.findAll();
    }
}
