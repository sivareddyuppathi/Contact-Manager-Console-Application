package com.erwin.fileManipilation;

import Demo.Contact;
import demo.Operations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteIntoTxtFile {
    
    public  static void fileSerialization(ArrayList<Contact> al) {
       

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("abc.txt");
            oos = new ObjectOutputStream(fos);
            List<Contact> a = null;
            oos.writeObject(al);
           // a = Operations.contactslist;

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                oos.close();
                
            } catch (IOException ex) {
                System.out.println("Exception");
               // Logger.getLogger(FileManiplations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void fileDeserialization() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        
        fis = new FileInputStream("abc.txt");
        ois = new ObjectInputStream(fis);        
       Operations.contactslist = (ArrayList<Contact>)ois.readObject();
           // System.out.println(Operations.contactslist);
       
       ois.close();

    }
}
