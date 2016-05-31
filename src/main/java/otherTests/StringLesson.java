package otherTests;

import org.testng.annotations.Test;

/**
 * Created by DimaM on 12/8/2015.
 */
public class StringLesson {

    String s = "My name is Dima";


    @Test
    public void stringTest() {

        String name = s.substring(11);  // указать начальный индекс откуда обрезать и конечный индекс.
        System.out.println(name);

        int indexBegin = s.indexOf("is ") + "is ".length(); // обрезаем длину тех символов, которые нашел потому что индексоф -станет переде из
        System.out.println(indexBegin);
        s.substring(indexBegin);
        System.out.println(s.substring(indexBegin));

    }

    @Test
    public void soutTest() {
        int a = 1;
        System.out.println("Original a value " + a);
        System.out.println("Post -increment " + a++);
        System.out.println("After Post -  increment  " + a);
        System.out.println("Pre - increment a " + ++a);
        System.out.println("After pre - increment " + a);

    }

    @Test
    public void puzurek() {
        boolean swapFlag = true;
        int[] inaArray = {3, 8, 11, 7, 10};
        int tempInt;
        while (swapFlag) {
            swapFlag = false;
            for (int j = 0; j < inaArray.length - 1; j++) {
                if (inaArray[j] < inaArray[j + 1]) {
                    tempInt = inaArray[j];
                    inaArray[j] = inaArray[j + 1];
                    inaArray[j + 1] = tempInt;
                    swapFlag = true;
                }
            }
        }

    }

    @Test
    public void escapeCharacters(){
        System.out.println("\t  privet");
        System.out.println("\b ssdsdwww");
        System.out.println("\r  sdsdswwww");
        System.out.println("\"  sdsdswwww");
    }


}
