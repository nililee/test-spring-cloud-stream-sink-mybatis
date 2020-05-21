/**
 *    Copyright 2015-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.example.actorsink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.actorsink.domain.Actor;
import com.example.actorsink.service.ActorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ActorController {

	private final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private ActorService actorService;

	@ResponseBody
	@GetMapping("/actor/{actorId}")
	public String getActorById(@PathVariable String actorId) throws JsonProcessingException {
		Actor actor = actorService.getActorById(actorId);
		return om.writerWithDefaultPrettyPrinter().writeValueAsString(actor);
	}

	@ResponseBody
	@GetMapping("/actor/list")
	public String getActors() throws JsonProcessingException {
		List<Actor> actors = actorService.getActors();
		return om.writerWithDefaultPrettyPrinter().writeValueAsString(actors);
	}
	
	/*
	@ResponseBody
	@PostMapping("/actor")
	public String addActor(@RequestBody Actor actor) throws JsonProcessingException {
		log.info("******************************************");
		log.info(actor.toString());
		log.info("******************************************");
		return om.writerWithDefaultPrettyPrinter().writeValueAsString(actor);
	}
	*/
}
