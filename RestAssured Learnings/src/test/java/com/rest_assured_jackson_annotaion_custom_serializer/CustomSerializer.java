package com.rest_assured_jackson_annotaion_custom_serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomSerializer extends StdSerializer<JsonCustomSerializerPOJO>{

	public CustomSerializer(Class<JsonCustomSerializerPOJO> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	
	public CustomSerializer() {

		this(null);
	}


	
	@Override
	public void serialize(JsonCustomSerializerPOJO value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		
		gen.writeStartObject();
		
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("name", value.getName());
		gen.writeStringField("email", value.getEmail());
		
		gen.writeEndObject();
	
	}
	
	
	
	
	

}
