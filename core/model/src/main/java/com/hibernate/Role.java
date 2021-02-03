package com.hibernate;
import java.util.*;

public class Role {
    private List<String> roles = new ArrayList<>();
    
    public List<String> addRole(String role) {
        roles.add(role);
        return roles;
    }
    
    public List<String> deleteRole(String role) {
        //roles.remove(role);
        return roles;
    }
}