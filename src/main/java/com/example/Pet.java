package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Skinner on 2/20/17.
 */
public class Pet {

    private String name;
    private String type;

    @JsonCreator
    public Pet(@JsonProperty("name") String name, @JsonProperty("type") String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
