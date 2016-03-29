import org.testng.annotations.Test;

/**
 * Created by DimaM on 7/21/2015.
 */
public class Lesson3 {


    String expectedURL="http://www.pdffiller.com/en/account/?op=account_info";

    @Test
    public void runTest1(){
        System.out.println( expectedURL.length());
    //  String newURL=  expectedURL.replaceAll("\\.", ":");
        String newURL2= expectedURL.substring(11,20);
       // System.out.println(newURL);
        System.out.println(newURL2);
        System.out.println(expectedURL.indexOf("."));
        String url2 =expectedURL.substring(expectedURL.indexOf(".")+".".length());
        System.out.println(url2);
    }


}
