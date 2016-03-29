package otherTests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by DimaM on 11/16/2015.
 */
public class game {

    public static void main(String[] args) throws Exception {



        Random random = new Random();
        int max = 10;
        int min = 0;
        int randomPCAnswer =  random.nextInt(max - min + 1) + min;
         int generatorNumber =    random.nextInt(max - min + 1) + min;



            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sn1 = reader.readLine();
            int human = Integer.parseInt(sn1);


        System.out.println("PC answer = "+randomPCAnswer);
        System.out.println("generator number = "+ generatorNumber);

        int a = Math.abs(generatorNumber - human);
        int b =  Math.abs(generatorNumber -randomPCAnswer);


            if (a < b) {
                System.out.println("human win " + human);

            }
        if ((a==b)) {System.out.println("numbers are equals, try again " ); }
         if (b<a)      {
                System.out.println("PC win " + randomPCAnswer);

            }

        }


    }


