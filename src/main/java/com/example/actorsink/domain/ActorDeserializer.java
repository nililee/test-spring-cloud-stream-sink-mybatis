package com.example.actorsink.domain;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ActorDeserializer extends StdDeserializer<Actor> {
	
	private static final long serialVersionUID = -3810791964793599877L;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public ActorDeserializer() {
        this(null);
    }
 
    public ActorDeserializer(Class<?> vc) {
        super(vc);
    }
    
    @Override
    public Actor deserialize(JsonParser parser, DeserializationContext deserializer) {
    	
    	Actor actor = new Actor();
        ObjectCodec codec = parser.getCodec();
        JsonNode node;
        
		try {
			node = codec.readTree(parser);
			
	        JsonNode payloadNode = node.get("payload");
	        actor.setActorId(payloadNode.get("actor_id").asText().toUpperCase());
	        actor.setFirstName(payloadNode.get("first_name").asText().toUpperCase());
	        actor.setLastName(payloadNode.get("last_name").asText().toUpperCase());
	        actor.setFullName(actor.getFirstName() + " " + actor.getLastName());
	        actor.setLastUpdate(sdf.format(new Date(new Timestamp(payloadNode.get("last_update").asLong()).getTime())));
	        actor.setCreationTime(sdf.format(new Date()));
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return actor;
    }
}
