// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
public interface ContactOperations<T>{  //similar to abstract calss Contact, this interface helps set up methods that are used in BusinessContact and PersonalContact
    public void Setfirstname(String name);
    public void SetLastName(String name);
    public String getfirstname();
    public String getlastname();
}
