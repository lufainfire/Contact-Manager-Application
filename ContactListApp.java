// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

// My next plan for this week is to use Swing a java GUI framework to build a user interface for the client to use
public class ContactListApp {

    static LinkedList<Contact> list = new LinkedList<Contact>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        new app();
        }
        public static class app extends  JFrame{
            JFrame f;
            app() {
                JFrame f = new JFrame("Manager");

                //First Option
                JLabel title1 = new JLabel("Add Contact");
                title1.setBounds(50,10,200,30);
                f.add(title1);
                //first name
                JLabel fname = new JLabel("First Name");
                fname.setBounds(250,10,200,30);
                f.add(fname);
                JTextField textname = new JTextField();
                textname.setBounds(250,40, 150, 30);
                f.add(textname);
                //Last name
                JLabel lname = new JLabel("Last Name");
                lname.setBounds(450,10,200,30);
                f.add(lname);
                JTextField textlname = new JTextField();
                textlname.setBounds(450,40, 150, 30);
                f.add(textlname);
                //Email
                JLabel email = new JLabel("Email");
                email.setBounds(650,10,200,30);
                f.add(email);
                JTextField textemail = new JTextField();
                textemail.setBounds(650,40, 150, 30);
                f.add(textemail);
                //Phone Number
                JLabel number = new JLabel("Phone Number");
                number.setBounds(850,10,200,30);
                f.add(number);
                JTextField textnumber = new JTextField();
                textnumber.setBounds(850,40, 150, 30);
                f.add(textnumber);
                //Option Business or Personal
                JLabel option1 = new JLabel("Choose Type of Contact:      Personal             Business");
                option1.setBounds(1050,10,400,30);
                f.add(option1);
                JCheckBox personal = new JCheckBox();
                personal.setBounds(1220,40,20,20);
                f.add(personal);
                JCheckBox business = new JCheckBox();
                business.setBounds(1320,40,20,20);
                f.add(business);
                //Submit button
                final JButton button1 = new JButton("Submit");
                button1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        if(personal.isSelected()){
                            Personalcontact b = new Personalcontact(textname.getText(), textlname.getText(), "personal", textnumber.getText());
                            list.add(b);
                        }
                        if(business.isSelected()){
                            Businesscontact b = new Businesscontact(textname.getText(), textlname.getText(), "business", textemail.getText());
                            list.add(b);
                        }
                    }
                });
                button1.setBounds(1500,40,100,30);
                f.add(button1);

                //Second Option
                JLabel title2 = new JLabel("Delete Last Contact");
                title2.setBounds(50,160,200,30);
                f.add(title2);
                final JButton button2 = new JButton("Delete");
                button2.addActionListener(this::boutton2);
                button2.setBounds(300,160,100,30);
                f.add(button2);

                //Third Option
                JLabel title3 = new JLabel("Display Contacts");
                title3.setBounds(50,320,200,30);
                f.add(title3);
                JTextArea text3 = new JTextArea();
                text3.setBounds(600,280, 800, 180);
                f.add(text3);
                final JButton button3 = new JButton("Display");
                button3.addActionListener(new ActionListener() {
                                             public void actionPerformed(ActionEvent ae) {
                                                 text3.setText(list.textoutputList());
                                             }
                                         });
                button3.setBounds(300,320,100,30);
                f.add(button3);
                //Fourth Option
                //Title
                JLabel title4 = new JLabel("Save Contacts");
                title4.setBounds(50,470,200,30);
                f.add(title4);
                //Subtitle
                JLabel save = new JLabel("How would you like to name the file:");
                save.setBounds(250,470,220,30);
                f.add(save);
                //TextBox
                JTextField textsave = new JTextField();
                textsave.setBounds(250,500,220,30);
                f.add(textsave);
                //Button
                final JButton button4 = new JButton("Save");
                button4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        ArrayList<Contact> result = list.toArray();
                        String txt="";
                        String filename = textsave.getText();
                        for (int i = 0; i < result.size(); i++) {
                            try {
                                txt += result.get(i).writeToFile() + "\n";      // create a String that contain all data present in Contact List
                            }catch (InvalidContactInformation e){
                                try {
                                    throw new FileNotFoundException();
                                } catch (FileNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                        try {                                               // creates a new file
                            PrintWriter outputStream = new PrintWriter(new
                                    FileOutputStream(filename));
                            outputStream.println(txt);                      // prints the data into the file
                            outputStream.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                button4.setBounds(480,500,100,30);
                f.add(button4);




                //Fifth Option
                JLabel title5 = new JLabel("Load Contact from file");
                title5.setBounds(50,620,200,30);
                f.add(title5);
                JLabel load = new JLabel("Name of the file to load:");
                load.setBounds(250,620,220,30);
                f.add(load);
                //TextBox
                JTextField textload = new JTextField();
                textload.setBounds(250,650,220,30);
                f.add(textload);
                //Button
                final JButton button5 = new JButton("Load");
                button5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        String word;
                        list.clear();
                        System.out.println("What is the name of the file to load (do not add .txt at the end");
                        String filesearch = textload.getText();
                        filesearch+=".txt";
                        try {                                                               // Uses the FileNotFound error and a try/catch block to capture any error
                            Scanner input = new Scanner(new FileInputStream(filesearch));
                            while (input.hasNextLine()) {
                                word = input.nextLine();
                                if (word.startsWith("business")) {  //analyses the data to add them to list
                                    String fword = word.substring(8, word.indexOf('&'));
                                    word = word.substring(word.indexOf('&') + 1);
                                    String lword = word.substring(0, word.indexOf('&'));
                                    String email = word.substring(word.indexOf('&') + 1);
                                    Businesscontact b = new Businesscontact(fword, lword, "business", email);
                                    list.add(b);

                                }
                                if (word.startsWith("personal")) {      // analyses the data present in the file to add them to Contact List
                                    String fword = word.substring(8, word.indexOf('&'));
                                    word = word.substring(word.indexOf('&') + 1);
                                    String lword = word.substring(0, word.indexOf('&'));
                                    String phone = word.substring(word.indexOf('&') + 1);
                                    Personalcontact c = new Personalcontact(fword, lword, "personal", phone);
                                    list.add(c);
                                }
                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                button5.setBounds(480,650,100,30);
                f.add(button5);


                //Sixth Option
                JLabel title6 = new JLabel("Quit Program");
                title6.setBounds(50,780,200,30);
                f.add(title6);
                final JButton button6 = new JButton("Quit");
                button6.addActionListener(this::boutton6);
                button6.setBounds(300,780,100,30);
                f.add(button6);

                //setting Dimensions and Layout
                f.setSize(1920, 1080);
                f.setLayout(null);
                f.setVisible(true);


            }
            public void boutton2(final ActionEvent e) {
                list.delete();
            }
            public void boutton6(final ActionEvent e) {
                System.exit(0);
            }
        }
    }