package informationSisOfSchool;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dima on 31.05.2016.
 */
public class Student extends ItemAbstractClass {

    String secondName;
    String name;
    int course;
    String bookNumber;
    String adress;
    String phone;

    public Student(String name, String secondName, int course, String bookNumber, String adress, String phone) {
        this.name = name;
        this.secondName = secondName;
        this.course = course;
        this.bookNumber = bookNumber;
        this.adress = adress;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student: "+name+ " "+ secondName +" " + course+" " + bookNumber+" " + adress +" " + phone;
    }

    @Override
    public String addItem() throws IOException {
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
        return (name + " " + secondName + " " + course + " " + bookNumber + " " + address + " " + phoneNumber );
    }

    @Override
    public List<String> deleteItem(List<String> list) throws IOException {
        return null;
    }

    @Override
    public List<String> updateItem(List<String> list) throws IOException {
        return null;
    }



}
