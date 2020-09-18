package com.imitation.restaurant.deliveryPerson.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.imitation.restaurant.deliveryPerson.model.DeliveryPerson;

import java.io.IOException;

public class DeliveryPersonSerializer extends StdSerializer<DeliveryPerson> {

    private static final long serialVersionUID = 1L;

    public DeliveryPersonSerializer() {
        this(null);
    }

    protected DeliveryPersonSerializer(Class<DeliveryPerson> t) {
        super(t);
    }

    @Override
    public void serialize(DeliveryPerson deliveryPerson, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("id", deliveryPerson.getId());
        generator.writeEndObject();
    }
}