package com.hibernate;

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class RoleUserInput {
    private Scanner sc = new Scanner(System.in);
    
    public void createRoleInput() {
        PersonService pService = new PersonService();
        RoleService rService = new RoleService();
        
        System.out.println("-----------Create Role----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        sc.nextLine();
        
        List<Person> persons = pService.findAllPersonByGWA();
    
        System.out.print("Enter Role: ");
        String inputRole = sc.nextLine();
        
        Role role = new Role(inputRole);
        role.setPersons(persons);
        
        rService.createRole(role);
    }
    
    public void deleteRoleInput() {
        PersonService pService = new PersonService();
        RoleService rService = new RoleService();
        
        System.out.println("-----------Delete Role----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Role ID: ");
        Integer roleIDToDelete = sc.nextInt();
        
        Person person = pService.findById(personID);
        List<Role> roles = rService.findAllRole();
        
        for(Role role : roles) {
            if(role.getRoleID() == roleIDToDelete) {
                rService.deleteRole(roleIDToDelete);
            }
        }
        
        person.setRoles(roles);
    }
    
    public void addRoleInput() {
        PersonService pService = new PersonService();
        RoleService rService = new RoleService();
        
        System.out.println("-----------Add Role----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Role ID: ");
        Integer roleIDToAdd = sc.nextInt();
        sc.nextLine();
        
        Person person = pService.findById(personID);
        List<Role> roles = rService.findAllRole();
        
        System.out.print("Enter additional role: ");
        String additionalRole = sc.nextLine();
        
        for(Role role : roles) {
            if(role.getRoleID() == roleIDToAdd) {
                role.setRole(role.getRole() + "," + additionalRole);
                rService.updateRole(role);
            }
        }
    }
    
    public void updateRoleInput() {
        PersonService pService = new PersonService();
        RoleService rService = new RoleService();
        
        System.out.println("-----------Update Role----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Role ID: ");
        Integer roleIDToAdd = sc.nextInt();
        sc.nextLine();
        
        Person person = pService.findById(personID);
        List<Role> roles = rService.findAllRole();
        
        
        
        for(Role role : roles) {
            if(role.getRoleID() == roleIDToAdd) {
                String[] rolesToUpdte = role.getRole().split(" ,");
                int n = 1;
                String finalUpdates = "";
                
                for(int i = 0; i < rolesToUpdte.length; i++) {
                    System.out.println(n + " " + rolesToUpdte[i]);
                    n++;
                }
                
                System.out.println("Select role to update");
                int roleOption = sc.nextInt();
                System.out.print("Enter role updates: ");
                String updatedRole = sc.nextLine();
                
                rolesToUpdte[roleOption-1] = updatedRole;
                
                for(int i = 0; i < rolesToUpdte.length; i++) {
                    if(i == rolesToUpdte.length-1) {
                        finalUpdates += rolesToUpdte[i];
                    }else {
                        finalUpdates += rolesToUpdte[i] + ",";
                    }
                }
                
                role.setRole(finalUpdates);
                rService.updateRole(role);
            }
        }
    }
    
    public void delRoleInput() {
        PersonService pService = new PersonService();
        RoleService rService = new RoleService();
        
        System.out.println("-----------Delete Role----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Role ID: ");
        Integer roleIDToAdd = sc.nextInt();
        sc.nextLine();
        
        Person person = pService.findById(personID);
        List<Role> roles = rService.findAllRole();
        
        
        
        for(Role role : roles) {
            if(role.getRoleID() == roleIDToAdd) {
                String[] rolesToUpdte = role.getRole().split(" ,");
                int n = 1;
                String finalUpdates = "";
                
                for(int i = 0; i < rolesToUpdte.length; i++) {
                    System.out.println(n + " " + rolesToUpdte[i]);
                    n++;
                }
                
                System.out.println("Select role to update");
                int roleOption = sc.nextInt();
                System.out.print("Enter role updates: ");
                String updatedRole = sc.nextLine();
                
                rolesToUpdte[roleOption-1] = updatedRole;
                
                for(int i = 0; i < rolesToUpdte.length; i++) {
                    if(i == rolesToUpdte.length-1) {
                        finalUpdates += rolesToUpdte[i];
                    }else {
                        finalUpdates += rolesToUpdte[i] + ",";
                    }
                }
                
                role.setRole(finalUpdates);
                rService.updateRole(role);
            }
        }
    }
    
    public void displayRoleInput() {
        RoleService rService = new RoleService();
        List<Role> roles = new ArrayList<>();
        System.out.println("-----------Roles----------\n");
        
        roles = rService.findAllRole();
        
        System.out.println("______________________________________");
            for(Role role : roles) {
                System.out.println("Roll ID: " + role.getRoleID() +
                                   "\nRoles: " + role.getRole() + "\n______________________________________");
            }
    }
}