package demo;

import com.erwin.fileManipilation.ReadWriteIntoTxtFile;
import com.erwin.util.Constants;
import java.util.ArrayList;
import java.util.Scanner;
import Demo.Contact;
import com.erwin.fileManipilation.ReadWriteIntoPropertiesFile;

public class Operations {

    public static ArrayList<Contact> contactslist = new ArrayList<Contact>();;

//    public Operations() {
//        //contactslist =    
//    }

    public static final Scanner scanner = new Scanner(System.in);

    public void exit() {
      //ReadWriteIntoTxtFile.fileSerialization(this.contactslist); //to writ into txt file
        ReadWriteIntoPropertiesFile.fileSerialization(this.contactslist);//to writ into properties file

        System.out.println(Constants.EXIT_MESSAGE);
        System.exit(0);
    }

    public void deleteContact() {

        listOfContacts();
        int x = scanner.nextInt();
       // contactslist.remove();
        System.out.println("Deleted Successfully");
        MainClass.startApplication();
    }

    public void listOfContacts() {

        System.out.println(Constants.LIST_OF_CONTACTS);
        if (!contactslist.isEmpty()) {
            System.out.println(Constants.HEADER + "\n" + Constants.BORDER);
            for (Contact e : contactslist) {
                System.out.println(e.getName() + "         " + e.getEmailId() + "         " + e.getMobileNumber());
            }
        } else {
            System.out.println(Constants.NO_CONTACTS);
        }
        MainClass.startApplication();
    }

    public void updateContact() {

        for (Contact e : contactslist) {
            System.out.println(Constants.UPDATECONTACT);
            int n = scanner.nextInt();
            switch (n) {
                case 1: {

                    System.out.println("enter Contact name ");
                    String name = scanner.next();
                    e.setName(name);
                    System.out.println("Name Upadated Successfully ");
                    MainClass.startApplication();
                    break;
                }
                case 2: {

                    System.out.println("enter gmailId ");
                    String gmailId = scanner.next();
                    e.setEmailId(gmailId);
                    System.out.println("gmailId Upadated Successfully ");
                    MainClass.startApplication();
                    break;
                }
                case 3: {
                    // a = e.getValue();
                    System.out.println("enter mobile Number ");
                    int mobile = scanner.nextInt();
                    e.setMobileNumber(mobile);
                    System.out.println("G-mailId Upadated Successfully ");
                    MainClass.startApplication();
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
    public void searchContact() {

        for (Contact e : contactslist) {
            System.out.println(Constants.SEARCH_BY);

            int n = scanner.nextInt();
            if (n == 1 || n == 2 || n == 3) {
                System.out.print(e.getName() + "     ");
                System.err.print(e.getEmailId() + "    ");
                System.err.print(e.getMobileNumber());
                MainClass.startApplication();
            } else {
                System.err.println("Please Select Correct Option");
                searchContact();
            }
        }
    }

    public void createContact() {

        System.out.println("Enter 'y'(or) 'Y' to Add Contact");
        char c = scanner.next().toLowerCase().charAt(0);
        while (c == 'y') {
            Contact contactsAddTOList = new Contact();

            System.out.print("Enter Name : ");
            String name = scanner.next();

            System.out.print("Enter Email Id : ");
            String gmailId = scanner.next();

            System.out.print("Enter Phone number : ");
            int mobileNum = scanner.nextInt();

            contactsAddTOList.setName(name);
            contactsAddTOList.setEmailId(gmailId);
            contactsAddTOList.setMobileNumber(mobileNum);
            contactslist.add(contactsAddTOList);
            System.out.println(Constants.INSERTION_SUCCESS);

            System.out.println("if you want to add more items enter 'y' else enter 'n'");
            char c1 = scanner.next().toLowerCase().charAt(0);
            if (c1 == 'y') {
                continue;
            } else {
                MainClass.startApplication();
                break;
            }

        }

    }

}
