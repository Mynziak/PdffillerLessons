package interfacesLesson;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Lolik on 24.12.2015.
 */
public class User {


    public User(String email, String password, String name, char gender, char searchGender, int age){
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.searchGender = searchGender;
        this.age = age;
    }


    public User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;

    }



    public User(String email, String password){
        this(email, password, "Jack", 'm', 'f', 22);
    }



    public String email;
    public String password;
    public char gender;
    public char searchGender;
    public String name;

    public int age;









    private void calculateUserAge(String birthdayDate){
        String birthday[] = birthdayDate.split("\\.");
        int year = Integer.parseInt(birthday[2]);
        int month = Integer.parseInt(birthday[1]);
        int day = Integer.parseInt(birthday[0]);

        LocalDate now = LocalDate.now();
        LocalDate userBirthday = LocalDate.of(year, month, day);
        age = Period.between(userBirthday, now).getYears();
    }

    @Override
    public String toString() {
        return "Response [email=" + email + ", password=" + password +  ", name=" + name +  ", gender=" + gender +
                ", searchGender=" + searchGender + ", age=" + age +
                "]";
    }



}
