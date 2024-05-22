import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
public class Businesscontact extends Contact implements ContactOperations{
    private String email;           //Uses Abstract class Contact as parent

    public Businesscontact(String first_name, String last_name, String field, String email){
        super(first_name, last_name, field);    // super uses class Contact's constructor
        this.email = email;
    }
    public void Setfirstname(String name){
        fname = name;
    }
    public void SetLastName(String name) {
        lname=name;
    }
    public void SetEmail(String name) {
        email = name;
    }
    public String getfirstname(){
        return fname;
    }
    public String getlastname(){
        return (lname);
    }
    public String getEmail(){
        return email;
    }
        public String toString (){
        return ("Contact name is "+fname+" "+lname+" Contact is of type " +field+ ", Contact's email is "+email);
    }
    public String writeToFile ()  {       //method to write object in txt.
            return (field + fname + '&' + lname + '&' + email);
    }    //similar to toString, this method outputs the data in a special format for txt save file
}
