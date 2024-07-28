package com.ps.repository;

import com.ps.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Tom");
        speaker.setLastName("Sawyer");

        speakers.add(speaker);

        return speakers;
    }
}
