package com.icsu.servicebus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public final class Person {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String lastName;
    private final String firstName;

    public Person(@JsonProperty String lastName, @JsonProperty String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Serializes an item into its JSON string equivalent.
     *
     * @return The JSON representation.
     *
     * @throws RuntimeException if the person could not be serialized.
     */
    public String toJson() {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not serialize object.", e);
        }
    }

    /**
     * Deserializes a JSON string into a Person.
     *
     * @return The corresponding person.
     *
     * @throws RuntimeException if the JSON string could not be deserialized.
     */
    public static Person fromJson(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not deserialize object.", e);
        }
    }
}