import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
public class Personalcontact extends Contact implements ContactOperations{  //Uses Abstract class Contact as parent
    private String phone;

    public Personalcontact(String first_name, String last_name, String field, String phone_number){
        super(first_name, last_name, field);    // super refers to parent class constructor
        phone = phone_number;
    }
    public void Setfirstname(String name){
        fname = name;
    }
    public void SetLastName(String name) {
        lname=name;
    }
    public void setPhone(String number) {
        phone = number;
    }
    public String getfirstname(){
        return fname;
    }
    public String getlastname(){
        return (lname);
    }
    public String getPhone(){
        return phone;
    }
    public String toString (){
        return ("Contact name is "+fname+" "+lname+" Contact is of type " +field+ ", Contact's phone number is "+phone);
    }
    public String writeToFile ()  {       //similar to toString, this method outputs the data in a special format for txt save file
        return (field+fname+'&'+lname+'&'+phone);
    }
}
