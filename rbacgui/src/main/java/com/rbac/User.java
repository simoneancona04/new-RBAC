package com.rbac;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.*;

public class User {
    private String username;
    private String password;
    private Boolean isAdmin;
    private ArrayList<Role> roles;

    @JsonCreator
    public User(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("roles") ArrayList<Role> roles, @JsonProperty("isAdmin") Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password, Boolean isAdmin){
        this.username = username;
        this.password = password;       
        this.roles = new ArrayList<Role>();
        this.isAdmin = isAdmin;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.isAdmin = false;

        this.roles = new ArrayList<Role>();
    }

    public User(){}

    @JsonIgnore
    public ArrayList<Operation> getOperations(){
        ArrayList<Operation> tmp = new ArrayList<>();
        for(Role role : roles){
            for(Operation o: role.getOperations()){
                if(!tmp.contains(o))
                    tmp.add(o);
            }
        }

        return tmp;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public void setAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    
    public Boolean isAdmin(){
        return isAdmin;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ArrayList<Role> getRoles(){
        return roles;
    }

    public void setRoles(ArrayList<Role> roles){
        this.roles = roles;
    }
}
