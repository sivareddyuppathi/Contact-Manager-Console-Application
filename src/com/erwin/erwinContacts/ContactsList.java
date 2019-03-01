package com.erwin.erwinContacts;

import com.erwin.util.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ContactsList {

    //public static final Logger LOGGER= Logger.getLogger(ContactsList.class.getName());
    public enum contactsList {

        CREATE, SEARCH, EDIT, SHOW, DELETE, EXIT
    }
    static ContactsEntry contactsAddTOMap = new ContactsEntry();
    private static final Scanner scanner = new Scanner(System.in);
    //static List<ContactsEntry> contactslist = new ArrayList<ContactsEntry>();
    
    public static Map<Integer, ContactsEntry> contactsMapObj = new HashMap<Integer, ContactsEntry>();

    public static void isEntry() {
       
        System.out.println(Constants.WELCOME_HEADER);
//        LOGGER.log(Level.INFO, "\n---------Welcome to Erwin Contacts List ------------\n ");

        System.out.print(Constants.OPTIONS);

        int optionSelected = scanner.nextInt();
        if (optionSelected > contactsList.values().length) {
            System.err.println("             ** In valid Choose With In Range **");
            isEntry();
        }
        contactsList chooseoption = contactsList.values()[optionSelected - 1];

        switch (chooseoption) {
            case CREATE:
                createContact();
                break;
            case SEARCH:
                searchContact();
                break;
            case EDIT:
                updateContact();
                break;
            case SHOW:
                listOfContacts();
                break;
            case DELETE:
                deleteContact();
                break;
            case EXIT:
                exit();
                break;
            default:
                System.out.print("Invalid Choice Please Choose Correct One from the List : ");
                isEntry();
                break;
        }
    }    
    private static void exit() {
        System.out.println("     Bye !!!!!!!!!1   ");
       System.exit(0);
    }

    private static void deleteContact() {
        
        listOfContacts();
        //System.out.println("list Of All Contacsts ");
        System.out.println("Enter key value :");
        int x = scanner.nextInt();
        contactsMapObj.remove(x);
        System.out.println("Deleted Successfully");
        isEntry();
    }

    private static void listOfContacts() {

        Set<Map.Entry<Integer, ContactsEntry>> s = contactsMapObj.entrySet();
        System.out.println("list Of All Contacsts ");

        if (!s.isEmpty()) {
            System.out.println(Constants.HEADER +"\n"+Constants.BORDER);
           // System.out.println(Constants.BORDER);
            for (Map.Entry<Integer, ContactsEntry> e : s) {
                ContactsEntry a = e.getValue();
                System.out.print(e.getKey());
                System.out.print("         ");
                System.out.print(a.getName());
                System.out.print("         ");
                System.out.print(a.getEmailId());
                System.out.print("         ");
                System.out.println(a.getMobileNumber());
            }
        } else {
            System.out.println("!Oops No Contacts Found");
        }
        isEntry();
    }

    private static void updateContact() {      
         //int i = 0;
        Set<Map.Entry<Integer, ContactsEntry>> s = contactsMapObj.entrySet();

        for (Map.Entry<Integer, ContactsEntry> e : s) {
         
            ContactsEntry a;
           
            System.out.println(Constants.UPDATECONTACT);
            int n = scanner.nextInt();
            switch (n) {
                case 1: {
                    a = e.getValue();
                    System.out.println("enter Contact name ");
                    String name = scanner.next();
                    a.setName(name);
                    System.out.println("Name Upadated Successfully ");
                    isEntry();
                    break;
                }
                case 2: {
                    a = e.getValue();
                    System.out.println("enter gmailId ");
                    String gmailId = scanner.next();
                    a.setEmailId(gmailId);
                    System.out.println("gmailId Upadated Successfully ");
                    isEntry();
                    break;
                }
                case 3: {
                    a = e.getValue();
                    System.out.println("enter mobile Number ");
                    int mobile = scanner.nextInt();
                    a.setMobileNumber(mobile);
                    System.out.println("G-mailId Upadated Successfully ");
                    isEntry();
                    break;
                }
                default: {
                    System.out.println("Enter Valid Number");
                    updateContact();
                    break;
                }
            }           
        }
    }

    private static void searchContact() {
        Set<Map.Entry<Integer, ContactsEntry>> s = contactsMapObj.entrySet();

        for (Map.Entry<Integer, ContactsEntry> e : s) {
           
            ContactsEntry a = e.getValue();
           
            System.out.println("enter 1 to search by name");
            System.out.println("enter 2 to search by email");
            System.out.println("enter 3 to search by mobile");

            System.out.println("enter ur choice");
            int n = scanner.nextInt();
            if (n == 1 || n == 2 || n == 3) {
                System.out.print(a.getName() + "     ");
                System.err.print(a.getEmailId() + "    ");
                System.err.print(a.getMobileNumber());
                isEntry();
            } else {
                System.err.println("Please Select Correct Option");
                searchContact();
            }
        }
    }
    private static void createContact() {

        System.out.println("Enter 'y'(or) 'Y' to Add Contact");
        char c = scanner.next().toLowerCase().charAt(0);
        int index = 1;
        while (c == 'y') {

            contactsAddTOMap = new ContactsEntry();

            System.out.print("Enter Name : ");
            String name = scanner.next();

            System.out.print("Enter Email Id : ");
            String gmailId = scanner.next();

            System.out.print("Enter Phone number : ");
            int mobileNum = scanner.nextInt();

            contactsAddTOMap.setName(name);
            contactsAddTOMap.setEmailId(gmailId);
            contactsAddTOMap.setMobileNumber(mobileNum);
            contactsMapObj.put(index, contactsAddTOMap);
           // contactslist.add(index,contactsAddTOMap);

            System.out.println("Successfully Inserted Into The PhoneBook");
            index++;
            System.out.println("if you want to add more items enter 'y' else enter 'n'");
            char c1 = scanner.next().toLowerCase().charAt(0);
            if (c1 == 'y') {
                continue;
            } else {
                isEntry();
                break;
            }

        }

    }

}
