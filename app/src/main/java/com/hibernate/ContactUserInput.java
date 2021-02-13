package com.hibernate;

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class ContactUserInput {
    private Scanner sc = new Scanner(System.in);
    
    public void createContactInput() {
        PersonService pService = new PersonService();
        ContactService cService = new ContactService();
        
        System.out.println("-----------Create Contact----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        
        Person person = pService.findById(personID);
        
        System.out.print("Enter Landline: ");
        long landLine = sc.nextLong();
        System.out.print("Enter Mobile Number: ");
        long mobileNumber = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        
        Contact contact = new Contact(landLine, mobileNumber, email);
        contact.setPerson(person);
        
        cService.createContact(contact);
    }
    
    public void updateContactInput() {
        PersonService pService = new PersonService();
        ContactService cService = new ContactService();
        
        System.out.println("-----------Update Contact----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Contact ID: ");
        Integer contactID = sc.nextInt();
        
        Person person = pService.findById(personID);
        Contact contact = cService.findById(contactID);
        
         System.out.print("1. Landline" + 
                           "\n2. Mobile Number" + 
                           "\n3. Email" +
                           "\nSelect Contact to edit: ");
        int contactOption = sc.nextInt();
        sc.nextLine();
        
        switch(contactOption) {
            case 1:
                System.out.print("Enter Landline: ");
                contact.setLandLine(sc.nextLong());
                break;
            case 2:
                System.out.print("Enter Mobile Number: ");
                contact.setMobileNumber(sc.nextLong());
                break;
            case 3:
                System.out.print("Enter Email: ");
                contact.setEmail(sc.nextLine());
                break;
        }
        
        contact.setPerson(person);
        cService.updateContact(contact);
    }
    
    public void deleteContactInput() {
        PersonService pService = new PersonService();
        ContactService cService = new ContactService();
        
        System.out.println("-----------Delete Contact----------\n");
        System.out.print("Enter Person ID: ");
        Integer personID = sc.nextInt();
        System.out.print("Enter Contact ID: ");
        Integer contactIDToDelete = sc.nextInt();
        
        Person person = pService.findById(personID);
        List<Contact> contacts = cService.findAllContact();
        
        for(Contact contact : contacts) {
            if(contact.getContactID() == contactIDToDelete) {
                cService.deleteContact(contactIDToDelete);
            }
        }
        
        person.setContacts(contacts);
    }
}