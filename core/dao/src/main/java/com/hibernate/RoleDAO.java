package com.hibernate;
import java.io.Serializable;
import java.util.List;

public interface RoleDAO<T, Id extends Serializable> {
    //Create or Role
    public void createRole(T entity);
    
    //Find Role
    public Role findById(Integer roleID);
    
    //Delete Role
    public void deleteRole(T entity);
    
    //Update Role
    public void updateRole(T entity);
    
    //find all Role
    public List<Role> findAllRole();
}