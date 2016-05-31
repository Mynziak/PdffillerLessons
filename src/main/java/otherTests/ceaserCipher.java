package otherTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dima on 30.05.2016.
 */
public class CeaserCipher {

    public static void main(String[] args) throws IOException {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabetChars = alphabet.toCharArray();

        String chift = "LBFCEFGHOJKLONOPQRSTUVWXYZ";
        char[] chiftChars = chift.toCharArray();

        System.out.println("Enter something here : ");

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();

            StringBuilder str = new StringBuilder("Shifr is : ");

            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < alphabetChars.length; j++) {
                    if (s.charAt(i) == alphabetChars[j]) {
                      //  System.out.println("J = " + j);
                        //podmena:
                        str.append(chiftChars[j]);
                    }
                }
            }
            System.out.println(str);


            // deshifrator
            System.out.println("Enter shifr here : ");

            BufferedReader bufferRead2 = new BufferedReader(new InputStreamReader(System.in));
            String f = bufferRead2.readLine();
            StringBuilder str2 = new StringBuilder("deshifruy this : ");

            for (int i = 0; i < f.length(); i++) {
                for (int j = 0; j < chiftChars.length; j++) {
                    if (f.charAt(i) == chiftChars[j]) {
                        System.out.println("J = " + j);
                        //podmena:
                        str2.append(alphabetChars[j]);
                    }
                }
            }
            System.out.println(str2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
