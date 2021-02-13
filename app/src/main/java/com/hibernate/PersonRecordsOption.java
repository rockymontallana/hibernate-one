package com.hibernate;
import java.util.*;
import java.io.*;

public class PersonRecordsOption {
    public void displayOptions() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("\n");
		System.out.println("----------PERSON RECORDS OPTIONS----------");
        System.out.println("   (1)     Create Record");
		System.out.println("   (2)     Delete Record");
		System.out.println("   (3)     Update Record");
		System.out.println("   (4)     Display Records");
		System.out.println("   (5)     Create Contact");
		System.out.println("   (6)     Update Contact");
		System.out.println("   (7)     Delete Contact");
		System.out.println("   (8)     Create Role");
		System.out.println("   (9)     Delete Role");
		System.out.println("   (10)    Add Role");
		System.out.println("   (11)    Update Role");
		System.out.println("   (12)    Delete Role");
		System.out.println("   (13)    Display Role");
		System.out.println("   (14)     Exit");
		System.out.println("\n");
		System.out.print("Select from options: ");
        int option = input.nextInt();
        System.out.println("");
        implementOption(option);
    }
    
    public void implementOption(int option) {
        UserInput ui = new UserInput();
        ContactUserInput cui = new ContactUserInput();
        RoleUserInput rui = new RoleUserInput();
        
        switch(option) {
            case 1:
                ui.createRecordInput();
                displayOptions();
                break;
            case 2:
                try{
                    ui.deleteRecordInput();
                }catch(Exception e){}

                displayOptions();
                break;
            case 3:
                ui.updateRecordInput();
                displayOptions();
                break;
            case 4:
                ui.displayRecords();
                displayOptions();
                break;
            case 5:
                cui.createContactInput();
                displayOptions();
                break;
            case 6:
                cui.updateContactInput();
                displayOptions();
                break;
            case 7:
                try{
                    cui.deleteContactInput();
                }catch(Exception e){}
                displayOptions();
                break;
            case 8:
                rui.createRoleInput();
                displayOptions();
                break;
            case 9:
                rui.deleteRoleInput();
                displayOptions();
                break;
            case 10:
                rui.addRoleInput();
                displayOptions();
                break;
            case 11:
                rui.updateRoleInput();
                displayOptions();
                break;
            case 12:
                rui.delRoleInput();
                displayOptions();
                break;
            case 13:
                rui.displayRoleInput();
                displayOptions();
                break;
            case 14:
                System.exit(0);
        }
    }
}
