package com.hibernate;

import java.util.List;

public class RoleService {
    private static RoleDAOImp roleDAOImp;
    
    public RoleService() {
        roleDAOImp = new RoleDAOImp();
    }
    
    public void createRole(Role role) {
        roleDAOImp.openCurrentSessionwithTransaction();
        roleDAOImp.createRole(role);
        roleDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public void updateRole(Role role) {
        roleDAOImp.openCurrentSessionwithTransaction();
        roleDAOImp.updateRole(role);
        roleDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public Role findById(int roleID) {
        roleDAOImp.openCurrentSessionwithTransaction();
        Role role = roleDAOImp.findById(roleID);
        roleDAOImp.closeCurrentSessionwithTransaction();
        
        return role;
    }
    
    public void deleteRole(Integer roleID) {
        roleDAOImp.openCurrentSessionwithTransaction();
        Role role = roleDAOImp.findById(roleID);
        roleDAOImp.deleteRole(role);
        roleDAOImp.closeCurrentSessionwithTransaction();
    }
    
    public List<Role> findAllRole() {
        roleDAOImp.openCurrentSessionwithTransaction();
        List<Role> roles = roleDAOImp.findAllRole();
        roleDAOImp.closeCurrentSessionwithTransaction();
        
        return roles;
    }
    
    public RoleDAOImp roleDAOImp() {
        return roleDAOImp;
    }
}