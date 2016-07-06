package informationSisOfSchool;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Created by Dima on 31.05.2016.
 */
public class DataTestClass {

    private static String vykladachiFilePath = new File("C:/sisTest/vykladachi.out").getAbsolutePath();
    private String studentsFilePath = new File("C:/sisTest/students.out").getAbsolutePath();



    public static void main(String[] args) throws IOException {


        List<Vykladach> vykladachi = deserializeVykladach ();
        List<Student> students =  new ArrayList<>();

//       vykladachi = deserializeVykladach ();
       System.out.println("!!!!  "+vykladachi);

        System.out.println("Select object of data:  v - Vykladach, s - Student, p - Predmet, g- Group: ");
        try {
            String object = getTextFromScreen();
            switch (object) {
                case "v":
                    System.out.println("Please select an action for Vykladach: ADD - add Vykladach, DELETE - delete Vykladach, UPDATE - change Vykladach, ALL - getList of Vykladaches, SELECT - select Vykladach");
                    String vykladachMethods = getTextFromScreen();
                    switch (vykladachMethods) {
                        case "ADD":
                            System.out.println("Enter name of Vykladach:");
                            String addVn = getTextFromScreen();
                            System.out.println("Enter secondName of Vykladach:");
                            String addVs = getTextFromScreen();
                           // vykladachi.add(new Vykladach(addVn, addVs));
                            System.out.println("!!" + vykladachi);
                            break;
                    }
                    break;
                case "s":
                    System.out.println("Please select an action for Student: ADD - add Student, DELETE - delete Student, UPDATE - change  Student, ALL - getList of  Student, SELECT - select  Student");
                    String studentMethods = getTextFromScreen();
                    switch (studentMethods) {
                        case "ADD":
                            System.out.println("Enter name of Student:");
                            String name = getTextFromScreen();
                            System.out.println("Enter secondName of Student:");
                            String secondName = getTextFromScreen();
                            System.out.println("Enter course of Student:");
                            int course = Integer.parseInt(getTextFromScreen());
                            System.out.println("Enter book Number of Student:");
                            String bookNumber = getTextFromScreen();
                            System.out.println("Enter address of Student:");
                            String address = getTextFromScreen();
                            System.out.println("Enter phone Number of Student:");
                            String phoneNumber = getTextFromScreen();
                            students.add(new Student(name, secondName, course, bookNumber, address, phoneNumber));
                            System.out.println("++" + students);
                            break;
                    }
                    break;
            }
            System.out.println("DO YOU WANT TO  SAVE CHANGES?  y/n :");
            String save = getTextFromScreen();
            if (save.equals("y")) {  //create files:
             searilizeVykladach(vykladachi);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTextFromScreen() throws IOException {
        BufferedReader bufferName = new BufferedReader(new InputStreamReader(System.in));
        return bufferName.readLine();
    }

    public static List<Vykladach> deserializeVykladach() {
        List<Vykladach> vykladaches = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(vykladachiFilePath));
            vykladaches = (List<Vykladach>) in.readObject();
            in.close();
        }
        catch(Exception e) {}
        return vykladaches;
    }

    public static void searilizeVykladach(List<Vykladach> _vykladach) {
        try {
            FileOutputStream fileOut = new FileOutputStream(vykladachiFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_vykladach);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

}
