package LessonExams;

import browserfactory.BrowseFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.File;

import java.util.List;

import java.io.IOException;

/**
 * Created by Dima on 03.06.2016.
 */
public class Exams extends BrowseFactory{



    public boolean isElementPresent (By locator) {
        if (driver.findElements(locator).size()>0) {
            return true;
        }
        return false;
    }

    public void updateString (String path, String updateString, String newString) throws IOException {
        File  file =  new File("C:/sisTest/students.txt");

        List <String> list = FileUtils.readLines(file);
        for (String currentString : list){
            if (currentString.equals(updateString)){
                list.add(list.indexOf(currentString), newString);
            }
        }
    }

    public void randMassive (){
     //  int m = math.

    }

}
