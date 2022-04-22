package com.rbac;

import com.fasterxml.jackson.annotation.*;

public class Operation {
    private String name;
    private String description;

    @JsonCreator
    public Operation(@JsonProperty("name") String name, @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        Operation op = (Operation)o;

        return op.name.equals(name) && op.description.equals(description);
    }
}
