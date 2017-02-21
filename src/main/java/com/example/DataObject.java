package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Skinner on 2/20/17.
 */
public class DataObject {
    Pet[] pets;

    @JsonCreator
    public DataObject(@JsonProperty("pets") Pet[] pets) {
        this.pets = pets;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }
}
