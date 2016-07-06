package otherTests.lessonPageFactory;

import org.testng.annotations.Test;

/**
 * Created by Dima on 05.07.2016.
 */
public class ThreadLoaclTestSecond extends LessonTreadLocal {

    @Test
    public void openPagetest (){
        driver().get("https://translate.google.com/");
    }
}
