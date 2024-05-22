import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
public abstract class Contact {         //This is the parent Class for BusinessContact and PersonalContact
    String fname;                       // This class is abstract because it will NOT be used to create any object
    String lname;
    String field;
    public Contact(){
        fname = "Alex";
        lname = "Jones";
        this.field = "normal";

    }
    public Contact(String first_name, String last_name, String field){
        fname = first_name;
        lname = last_name;
        this.field = field;
    }
    public String writeToFile () throws InvalidContactInformation  {

            return(field+fname+'&'+lname);

    }
    public String toString (){
        return ("Contact name is "+fname+" "+lname+" Contact is of type " +field);
    }
}
