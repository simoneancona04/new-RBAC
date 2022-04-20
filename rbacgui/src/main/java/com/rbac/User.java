package com.rbac;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Boolean isAdmin;
    private ArrayList<Role> roles;

    

    public User(String username, String password, ArrayList<Role> roles){
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<Role>();
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<Role>();
    }

    public User(){}

    public void addRole(Role role){
        this.roles.add(role);
    }

    public void setAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    
    public Boolean getIsAdmin(){
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
