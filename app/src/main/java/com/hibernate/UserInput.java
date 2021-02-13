package com.hibernate;

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class UserInput {
    private Scanner sc = new Scanner(System.in);
    
    public void createRecordInput() {
        PersonService pService = new PersonService();
        
        System.out.println("-----------Create Record----------\n");
        System.out.print("Enter Lastname: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Firstname: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Middlename: ");
        String middleName = sc.nextLine();
        System.out.print("Enter Suffix: ");
        String suffix  = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Street No: ");
        String streetNo = sc.nextLine();
        System.out.print("Enter Barangay: ");
        String barangay = sc.nextLine();
        System.out.print("Enter City/Municipality: ");
        String cityOrMunicipality = sc.nextLine();
        System.out.print("Enter Zipcode: ");
        int zipcode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Birthday: ");
        String sBirthday = sc.nextLine();
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("dd-MM-yyyy").parse(sBirthday);
        }catch (Exception e) {}
        
        System.out.print("Enter General Weighted Average: ");
        double gradeWeightedAverage = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Date Hired: ");
        String sDateHired = sc.nextLine();
        Date dateHired = null;
        try {
           dateHired  = new SimpleDateFormat("dd-MM-yyyy").parse(sDateHired);
        }catch (Exception e) {}
        
        System.out.print("Currently Employed? (Y/N): ");
        boolean isCurrentlyEmployed;
        if(sc.nextLine() == "Y" || sc.nextLine() == "y") {
            isCurrentlyEmployed = true;
        }else {
            isCurrentlyEmployed = false;
        }
        sc.nextLine();
          
        Person person = new Person(lastName, firstName, middleName, suffix, title, 
                                   streetNo, barangay, cityOrMunicipality, zipcode, 
                                   birthday, gradeWeightedAverage, dateHired, isCurrentlyEmployed);
        
        pService.createPerson(person);
    }
    
    public void deleteRecordInput() throws Exception, IOException{
        PersonService pService = new PersonService();
        System.out.println("-----------Delete Record----------\n");
        System.out.println("Enter user ID to delete: ");
        Integer userIDToDelete = sc.nextInt();
        pService.deletePerson(userIDToDelete);
        System.out.println("User deleted!");
    }
    
    public void updateRecordInput() {
        PersonService pService = new PersonService();
        System.out.println("-----------Update Record----------\n");
        System.out.println("Enter user ID to update: ");
        int userIDToUpdate = sc.nextInt();
        
        Person person = pService.findById(userIDToUpdate);
        
        System.out.println("1. Lastname" + 
                           "\n2. Firstname" + 
                           "\n3. Middlename" +
                           "\n4. Suffix" +
                           "\n5. Title" +
                           "\n6. Street No" +
                           "\n7. Barangay" +
                           "\n8. City/municipality" +
                           "\n9. Zipcode" +
                           "\n10. Birthday" +
                           "\n11. Grade Weighted Average" +
                           "\n12. Date Hired" +
                           "\n13. Employment Status");
        System.out.print("Select information to edit (1-13): ");
        int updateChoice = sc.nextInt();
        sc.nextLine();
        
        switch(updateChoice) {
            case 1: 
                System.out.print("Enter new lastname: ");
                person.setLastName(sc.nextLine());
                break;
            case 2: 
                System.out.print("Enter new firstname: ");
                person.setFirstName(sc.nextLine());
                break;
            case 3: 
                System.out.print("Enter new middlename: ");
                person.setMiddleName(sc.nextLine());
                break;
            case 4: 
                System.out.print("Enter new suffix: ");
                person.setSuffix(sc.nextLine());
                break;
            case 5: 
                System.out.print("Enter new title: ");
                person.setTitle(sc.nextLine());
                break;
            case 6: 
                System.out.print("Enter new street no: ");
                person.setStreetNo(sc.nextLine());
                break;
            case 7: 
                System.out.print("Enter new barangay: ");
                person.setBarangay(sc.nextLine());
                break;
            case 8: 
                System.out.print("Enter new city/municipality: ");
                person.setCityOrMunicipality(sc.nextLine());
                break;
            case 9: 
                System.out.print("Enter new zipcode: ");
                person.setZipcode(sc.nextInt());
                break;
            case 10: 
                System.out.print("Enter new birthday: ");
                Date birthday = null;
                try {
                    String newBirthday = sc.nextLine();
                    birthday = new SimpleDateFormat("dd-MM-yyyy").parse(newBirthday);
                }catch (Exception e) {}
                person.setBirthday(birthday);
                break;
            case 11:
                System.out.print("Enter new GWA: ");
                person.setGradeWeightedAverage(sc.nextDouble());
                break;
            case 12: 
                System.out.print("Enter new birthday: ");
                Date dateHired = null;
                try {
                    String newDateHired = sc.nextLine();
                    dateHired = new SimpleDateFormat("dd-MM-yyyy").parse(newDateHired);
                }catch (Exception e) {}
                person.setDateHired(dateHired);
                break;
            case 13:
                System.out.print("Enter new employment status: ");
                boolean isCurrentlyEmployed;
                if(sc.nextLine() == "Y" || sc.nextLine() == "y") {
                    isCurrentlyEmployed = true;
                }else {
                    isCurrentlyEmployed = false;
                }
                person.setIsCurrentlyEmployed(isCurrentlyEmployed);
                break;
        }
        
        pService.updatePerson(person);
    }
    
    public void displayRecords() {
        PersonService pService = new PersonService();
        List<Person> persons = new ArrayList<>();
        System.out.println("-----------Records----------\n");
        
        System.out.println("1. By GWA" +
                        "\n2. By Date Hired" +
                        "\n3. By Lastname");
        System.out.print("Select display Options");
        int displayOption = sc.nextInt();
        
        switch(displayOption) {
            case 1:
                persons = pService.findAllPersonByGWA();
                Collections.sort(persons, new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return Double.compare(person1.getGradeWeightedAverage(), person2.getGradeWeightedAverage());
                    }
                });
                break;
            case 2:
                persons = pService.findAllPersonByDateHired();
                break;
            case 3:
                persons = pService.findAllPersonByLastName();
                break;
        }
        
        System.out.println("______________________________________");
            for(int i = 0; i < persons.size(); i++) {
                Person person = persons.get(i);
                System.out.println("ID: " + person.getPersonID() + "\n" +
                                  "Lastname: " + person.getLastName() + "\n" +
                                  "Firstname: " + person.getFirstName() + "\n" +
                                  "Middlename: " + person.getMiddleName() + "\n" +
                                  "Suffix: " + person.getSuffix() + "\n" +
                                  "Title: " + person.getTitle() + "\n" +
                                  "Street No: " + person.getStreetNo() + "\n" +
                                  "Barangay: " + person.getBarangay() + "\n" +
                                  "City/Municipality: " + person.getCityOrMunicipality() + "\n" +
                                  "Zipcode: " + person.getZipcode() + "\n" +
                                  "Birthday: " + person.getBirthday() + "\n" +
                                  "GWA: " + person.getGradeWeightedAverage() + "\n" +
                                  "Date Hired: " + person.getDateHired() + "\n" +
                                  "Employment Status: " + person.getIsCurrentlyEmployed() + "\n______________________________________");
            }
    }
}