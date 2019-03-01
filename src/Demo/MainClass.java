package demo;


import com.erwin.fileManipilation.ReadWriteIntoPropertiesFile;
import com.erwin.fileManipilation.ReadWriteIntoTxtFile;
import com.erwin.util.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {
   // public static FileManiplations fm=new FileManiplations();
    public static  Scanner scanner = null;
   static public Operations operations = null;

   public MainClass(){
       scanner = new Scanner(System.in);
       operations = new Operations();
   }
    public enum MenuBar {
        CREATE, SEARCH, EDIT, SHOW, DELETE, EXIT
    }
    public static void startApplication() { 

        System.out.println(Constants.WELCOME_HEADER);
//        LOGGER.log(Level.INFO, "\n---------Welcome to Erwin Contacts List ------------\n ");

        System.out.print(Constants.OPTIONS);

        int optionSelected = scanner.nextInt();
        if (optionSelected > MenuBar.values().length) {
            System.err.println(Constants.ERRORMESSAGE);
            startApplication();
        }
        MenuBar chooseoption = MenuBar.values()[optionSelected - 1];

        switch (chooseoption) {
            case CREATE:
                operations.createContact();

                break;
            case SEARCH:
                operations.searchContact();
                break;
            case EDIT:
                operations.updateContact();
                break;
            case SHOW:
                operations.listOfContacts();
                break;
            case DELETE:
                operations.deleteContact();
                break;
            case EXIT:
                operations.exit();
                break;
            default:
                System.out.print(Constants.INVALIDCHOICE);
                startApplication();
                break;
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException  {
        
      ReadWriteIntoTxtFile.fileDeserialization(); //to writ into txt file
       ReadWriteIntoPropertiesFile.fileDeserialization();//to writ into properties file
        MainClass ob = new MainClass();
        ob.startApplication();

    }

}
