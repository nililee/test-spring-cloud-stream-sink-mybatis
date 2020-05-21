package com.example.actorsink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.actorsink.domain.Actor;
import com.example.actorsink.mapper.ActorMapper;

@Service
@Transactional
public class ActorService {
	
    @Autowired
    ActorMapper actorMapper;

    public Actor getActorById(String actorId) {
        return actorMapper.selectActorById(actorId);
    }

    public List<Actor> getActors() {
        return actorMapper.selectActors();
    }

    public void addActor(Actor actor) {
    	actorMapper.insertActor(actor);
    }
}