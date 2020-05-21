package com.example.actorsink.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.actorsink.domain.Actor;

@Repository
@Mapper
public interface ActorMapper {
    Actor selectActorById(String actorId);
    List<Actor> selectActors();
    void insertActor(Actor actor);
}