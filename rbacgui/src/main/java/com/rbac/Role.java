package com.rbac;

import java.util.ArrayList;

public class Role {
    private String name;
    private String description;
    private ArrayList<Operation> operations;

    public Role(String name, String description, ArrayList<Operation> operations) {
        this.name = name;
        this.description = description;
        this.operations = new ArrayList<Operation>();
    }

    public Role(String name, String description){
        this.name = name;
        this.description = description;
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
}
