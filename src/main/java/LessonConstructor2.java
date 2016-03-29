import org.testng.annotations.Test;

/**
 * Created by DimaM on 8/18/2015.
 */
public class LessonConstructor2 {
    LessonConstrucor construcor1 = new LessonConstrucor("dima");
    LessonConstrucor construcor2 = new LessonConstrucor();
LessonConstrucor construcor3 = new LessonConstrucor("dima", 28);
    @Test
    public void const1(){
        System.out.println(construcor1.name);
        System.out.println(construcor2.name);
        System.out.println(construcor3.name);
        System.out.println(construcor3.value);
    }

}

