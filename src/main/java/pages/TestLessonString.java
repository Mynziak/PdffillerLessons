package pages;

import org.testng.annotations.Test;

/**
 * Created by DimaM on 10/29/2015.
 */
public class TestLessonString {

    LessonString lessonString = new LessonString();

    @Test
    public void testStatic (){
        System.out.println(lessonString.nonStaticName);
        System.out.println(LessonString.CHROME_DRIVER_PATH); //call by using class.
        System.out.println(LessonString.name);//call by using class.

        LessonString test1 = new LessonString();
        LessonString test2 = new LessonString();

        System.out.println(test1.name.toString());
        System.out.println(test2.name);
        System.out.println(new LessonString().nonStaticName);
    }
}
