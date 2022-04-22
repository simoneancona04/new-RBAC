package com.rbac;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.*;

public class Role {
    private String name;
    private String description;
    private ArrayList<Operation> operations;

    @JsonCreator
    public Role(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("operations") ArrayList<Operation> operations) {
        this.name = name;
        this.description = description;
        this.operations = operations;
    }

    public Role(String name, String description){
        this.name = name;
        this.description = description;
        this.operations = new ArrayList<Operation>();
    }

    public Role(){}


    public void addOperation(Operation operation){
        this.operations.add(operation);
    }
    

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public ArrayList<Operation> getOperations(){
        return operations;
    }

    public void setOperations(ArrayList<Operation> operations){
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {
        Role r = (Role)o;
        if(r.operations.size() != operations.size()) return false;
        for(int i = 0; i < operations.size(); i++) {
            if(!r.operations.get(i).equals(operations.get(i))) return false;

        }

        if(!(r.name.equals(name) && r.description.equals(description))) return false;
        return true;
    }

    public void removeOperation(Operation operation) {
        operations.remove(operation);
    }
}
