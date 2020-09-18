package com.imitation.restaurant.item.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.imitation.restaurant.item.model.Item;

import java.io.IOException;

public class ItemIdSerializer extends StdSerializer<Item> {

	private static final long serialVersionUID = 1L;

	public ItemIdSerializer() {
		this(null);
	}

	protected ItemIdSerializer(Class<Item> t) {
		super(t);
	}

	@Override
	public void serialize(Item item, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", item.getId());
		generator.writeEndObject();
	}

}
