package otherTests.sudoku;

import java.util.*;

/**
 * Created by Dima on 25.04.2016.
 */
public class Sudoku2 {


    public static void main(String[] args) {
        Random rnd = new Random();

        Integer [][] array = new Integer[9][9];


        List<Integer> list1 = rndList();
        List<Integer> list2 = rndList();
        List<Integer> list3 = rndList();

        System.out.println("!!! "+list1);



//        for( int i = 0 ; i < array.length ; i++ ) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][0] = list1.get(i);
//                if (!list1.equals(list2)){
//                    array[i][1] = list2.get(i);} else {
//                    list2 = rndList();
//                }
//                if (!list1.equals(list3)){
//                    array[i][2] = list3.get(i);} else {
//                    list3 = rndList();
//                }
//
//
//            }
//        }

        for( int i = 0 ; i < array.length ; i++ ) {
            for ( int j = 0 ; j < array[i].length ; j++ ) {
               do
                array[i][j] = rnd.nextInt(10);
               while (!array[i][0].equals(array[i][0]));
            }
        }

        for( Integer [] a : array ) {
            System.out.println( Arrays.toString(a));
        }
    }

    public static List<Integer> rndList() {
        List<Integer> a = new ArrayList<>(9);
        for (int i = 1; i <= 9; i++){ //to generate from 0-10 inclusive.
            a.add(i);
        }
        Collections.shuffle(a);
        return a;
    }


}
