package otherTests;

/**
 * Created by Dima on 30.05.2016.
 */
public class CompareStringAdditions {


    public static void main(String[] args) {
        String s = "Dima";

        String simpleS = null;
        for (int i = 0; i < 10000; i++) {
            simpleS +=  "sss"+i;
        }
        System.out.println(simpleS);

    }
}
