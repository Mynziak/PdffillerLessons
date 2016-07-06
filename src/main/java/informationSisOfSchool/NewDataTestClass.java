package informationSisOfSchool;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 02.06.2016.
 */
public class NewDataTestClass {

    private static String vykladachiFilePath = new File("C:/sisTest/vykladachi.txt").getAbsolutePath();
    private static String studentsFilePath = new File("C:/sisTest/students.txt").getAbsolutePath();

    public static void main(String[] args) throws IOException {


        List<String> vykladachi = Files.readAllLines(Paths.get(vykladachiFilePath));
        List<String> students = Files.readAllLines(Paths.get(studentsFilePath));

        System.out.println("Vyklad = " + vykladachi);
        System.out.println("students= " + students);
        Vykladach vykladachItem = new Vykladach();

        System.out.println("Select object of data:  v - Vykladach, s - Student, p - Predmet, g- Group: ");
        try {
            String object = getTextFromScreen().toLowerCase();
            switch (object) {
                case "v":
                    System.out.println("Please select an action for Vykladach: ADD - add Vykladach, DELETE - delete Vykladach, UPDATE - change Vykladach, ALL - getList of Vykladaches, SELECT - select Vykladach");
                    String vykladachMethods = getTextFromScreen().toLowerCase();
                    switch (vykladachMethods) {
                        case "add":
                            vykladachi.add(vykladachItem.addItem());
                            break;
                        case "delete":
                            vykladachi = vykladachItem.deleteItem(vykladachi);
                            break;
                        case "update":
                            vykladachi = vykladachItem.updateItem(vykladachi);
                            break;
                    }
                    break;
                case "s":
                    System.out.println("Please select an action for Student: ADD - add Student, DELETE - delete Student, UPDATE - change  Student, ALL - getList of  Student, SELECT - select  Student");
                    String studentMethods = getTextFromScreen().toLowerCase();
                    switch (studentMethods) {
                        case "add":
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
                            students.add(name + " " + secondName + " " + course + " " + bookNumber + " " + address + " " + phoneNumber + " :");
                            System.out.println("++" + students);
                            break;
                    }
                    break;
            }

            System.out.println("DO YOU WANT TO  SAVE CHANGES?  y/n :");
            String save = getTextFromScreen().toLowerCase();
            if (save.equals("y")) {
                //update files : create new
                List<String> vykladachiOld = Files.readAllLines(Paths.get(vykladachiFilePath));
                List<String> studentsOld = Files.readAllLines(Paths.get(studentsFilePath));
                if (!vykladachiOld.equals(vykladachi)) {
                    FileUtils.writeLines(new File(vykladachiFilePath), vykladachi);
                }
                if (!studentsOld.equals(students)) {
                    FileUtils.writeLines(new File(studentsFilePath), students);
                }

                System.out.println("Updated Vykladachi =  " + vykladachi);
                System.out.println("Updated Students  = " + students);
            } else System.out.println("Changes are not saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTextFromScreen() throws IOException {
        BufferedReader bufferName = new BufferedReader(new InputStreamReader(System.in));
        return bufferName.readLine();
    }
}
