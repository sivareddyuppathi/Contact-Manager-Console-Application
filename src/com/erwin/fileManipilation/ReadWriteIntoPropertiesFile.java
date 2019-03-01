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
import java.util.Properties;

public class ReadWriteIntoPropertiesFile {
    
    public static Properties prop = new Properties();
    
    public static void fileSerialization(ArrayList<Contact> al) {       
        
        ObjectOutputStream oos = null;
        try {
//            FileInputStream fis = new FileInputStream("D:\\Projects\\JavaProjects\\Java_Pocs\\Day1_Poc\\data.properties.txt");//("abc.txt");
//            prop.load(fis);
            FileOutputStream fos = new FileOutputStream("demo.properties");
            oos = new ObjectOutputStream(fos);           
            oos.writeObject(al);      
        } 
        catch (IOException ex) {
            ex.printStackTrace();            
        } 
        finally {
            try {
                oos.close();

            } catch (IOException ex) {
                System.out.println("Exception");
                // Logger.getLogger(FileManiplations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    public static void fileDeserialization() throws FileNotFoundException, IOException, ClassNotFoundException {
        
       // fis = null;
     //  ois = null;
//       FileInputStream fis = new FileInputStream("D:\\Projects\\JavaProjects\\Java_Pocs\\Day1_Poc\\data.properties.txt");//("abc.txt");
//       prop.load(fis);
        
      FileInputStream  is = new FileInputStream("demo.properties");//("abc.txt");
        ObjectInputStream  ois = new ObjectInputStream(is);
        Operations.contactslist = (ArrayList<Contact>) ois.readObject();
       
        ois.close();
        
    }
}
