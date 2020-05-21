package com.example.actorsink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

import com.example.actorsink.domain.Actor;
import com.example.actorsink.service.ActorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableBinding(ActorSinkApplication.Sink.class)
@MapperScan(basePackages = "com.example.actorsink")
public class ActorSinkApplication {

	@Autowired
	private ActorService actorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ActorSinkApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void receive(Actor actor) {
		
		log.info("\n****************** At the Sink ******************");
		log.info("Received : " + actor);
		
		actorService.addActor(actor);
	}
	
	public interface Sink {
		String INPUT = "actor-sink";

		@Input(INPUT)
		SubscribableChannel sampleSink();
	}
}
