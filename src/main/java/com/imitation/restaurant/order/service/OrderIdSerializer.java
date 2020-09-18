package com.imitation.restaurant.order.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.imitation.restaurant.order.model.Order;

import java.io.IOException;

public class OrderIdSerializer extends StdSerializer<Order> {

	private static final long serialVersionUID = 1L;

	public OrderIdSerializer() {
		this(null);
	}

	protected OrderIdSerializer(Class<Order> t) {
		super(t);
	}

	@Override
	public void serialize(Order order, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", order.getId());
		generator.writeEndObject();
	}

}
