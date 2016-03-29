package otherTests;

import org.testng.annotations.Test;

/**
 * Created by DimaM on 11/12/2015.
 */
public class switchDemo {


    @Test
    public void testSwitchDemo(){

        int month = 2;
        String monthString ;

        switch(month){
            case 1: monthString = "January"; break;
            case 2: monthString = "February"; break;
            default: monthString = "Month is absent"; break;
        }
        System.out.println(monthString);

    }


}
