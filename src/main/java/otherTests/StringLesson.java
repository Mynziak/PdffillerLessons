package otherTests;

import org.testng.annotations.Test;

/**
 * Created by DimaM on 12/8/2015.
 */
public class StringLesson {

    String s = "My name is Dima";


    @Test
    public void stringTest (){

        String name = s.substring(11);  // указать начальный индекс откуда обрезать и конечный индекс.
        System.out.println(name);

        int indexBegin = s.indexOf("is ")+"is ".length(); // обрезаем длину тех символов, которые нашел потому что индексоф -станет переде из
        System.out.println(indexBegin);
        s.substring(indexBegin);
        System.out.println(s.substring(indexBegin));

    }
}
