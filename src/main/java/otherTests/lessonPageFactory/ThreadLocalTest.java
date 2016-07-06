package otherTests.lessonPageFactory;

import org.testng.annotations.Test;

/**
 * Created by Dima on 05.07.2016.
 */
public class ThreadLocalTest extends LessonTreadLocal {


    @Test
    public void openPagetest (){
        driver().get("http://www.pdffiller.com/");
    }
}
