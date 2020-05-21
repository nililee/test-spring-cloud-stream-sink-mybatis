package com.example.actorsink.domain;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@Alias("actor")
@JsonDeserialize(using = ActorDeserializer.class)
public class Actor {
	
	private String actorId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String lastUpdate;
	private String creationTime;
	
}
