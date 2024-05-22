// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
public class InvalidContactInformation extends Exception {
        public 	 InvalidContactInformation( )           //while be thrown if the information for Contact are wrong
        {
            super("Contact information are wrong");
        }       //print error message: "Contact information are wrong"
        public InvalidContactInformation(String message)             //second case of exception
        {
            super(message);
        }
}
