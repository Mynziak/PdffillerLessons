package otherTests.sudoku;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by DimaM on 11/11/2015.
 */
public class Sudoku {


    public List<Integer> generateSet(Random rng) {
        Set<Integer> generatedSet = new LinkedHashSet<Integer>();
        while (generatedSet.size() < 9) {
            Integer next = rng.nextInt(9) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generatedSet.add(next);
        }

        Iterator iterator = generatedSet.iterator();
        // check values
        List<Integer> list = new ArrayList<Integer>(generatedSet);
        return list;
    }


    public List<Integer>  rndList () {
        List<Integer> a = new ArrayList<>(9);
        for (int i = 1; i <= 9; i++){ //to generate from 0-10 inclusive.
            a.add(i);
        }
        Collections.shuffle(a);
        return a;
    }



    public List compareLists2(List list1, List list2) {

            for (int i = 0; i < 8; i++) {
                if (list1.get(i) != list2.get(i)) {
                    break;
                  } else {do {list2 = rndList();}
                while (list1.get(i) != list2.get(i));
                }
        }
        return list2;
    }

    public List compareLists3(List list1, List list2) {

        for (int i = 0; i < 8; i++) {
            if (list1.get(i) != list2.get(i)) {
                break;
            } else {do {list2 = rndList();}
            while (list1.get(i) != list2.get(i));
            }
        }
        return list2;
    }

    public List compareLists(List list1, List list2) {

//      boolean a = true;
//        while (a) {
//            for (int i = 0; i < 9; i++) {
//                if (list1.get(i) == list2.get(i)) {
//                    list2 = rndList(rng);
//                    break;
//                } else {
//                    a = false;
//                }
//            }
//        }
//        return list2;

        while (true) {
            int equalElements = 9;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    equalElements--;
                }
                else {
                    list2 = rndList();
                    break;
                }
            }
            if (equalElements == 0) {
                break;
            }
        }
        return list2;
    }

    public List retunClist (List list1, List list2, List list3, List list4,List list5,List list6,List list7,List list8 ,List list9){

        list2 = compareLists(list1, list2);
        list2 = compareLists(list3, list2);
        list2 = compareLists(list4, list2);
        list2 = compareLists(list5, list2);
        list2 = compareLists(list6, list2);
        list2 = compareLists(list7, list2);
        list2 = compareLists(list8, list2);
        list2 = compareLists(list9, list2);
        return  list2;
    }

    public void retunClist1 (List list1, List list2, List list3, List list4,List list5,List list6,List list7,List list8 ,List list9){

        list2 = compareLists(list1, list2);
        list3 = compareLists(list1, list3);
        list4 = compareLists(list1, list4);
        list5 = compareLists(list1, list5);
        list6 = compareLists(list1, list6);
        list7= compareLists(list1, list7);
        list8 = compareLists(list1, list8);
        list9 = compareLists(list1, list9);

       // list2 = compareLists(list2, list2);
        list3 = compareLists(list2, list3);
        list4 = compareLists(list2, list4);
        list5 = compareLists(list2, list5);
        list6 = compareLists(list2, list6);
        list7 = compareLists(list2, list7);
        list8 = compareLists(list2, list8);
        list9 = compareLists(list2, list9);

      //  list3 = compareLists(list2, list3);
        list4 = compareLists(list3, list4);
        list5 = compareLists(list3, list5);
        list6 = compareLists(list3, list6);
        list7 = compareLists(list3, list7);
        list8 = compareLists(list3, list8);
        list9 = compareLists(list3, list9);

       // list4 = compareLists(list3, list4);
        list5 = compareLists(list4, list5);
        list6 = compareLists(list4, list6);
        list7 = compareLists(list4, list7);
        list8 = compareLists(list4, list8);
        list9 = compareLists(list4, list9);



        //list5 = compareLists(list4, list5);
        list6 = compareLists(list5, list6);
        list7 = compareLists(list5, list7);
        list8 = compareLists(list5, list8);
        list9 = compareLists(list5, list9);

        list7 = compareLists(list6, list7);
        list8 = compareLists(list6, list8);
        list9 = compareLists(list6, list9);


        list8 = compareLists(list7, list8);
        list9 = compareLists(list8, list9);

        list9 = compareLists(list8, list9);

        System.out.println("----+- ge 1 = " + list1);
        System.out.println("----+- ge 2 = " + list2);
        System.out.println("----+- ge 3 = " + list3);
        System.out.println("----+- ge 4 = " + list4);
        System.out.println("----+- ge 5 = " + list5);
        System.out.println("----+- ge 6 = " + list6);
        System.out.println("----+- ge 7 = " + list7);
        System.out.println("----+- ge 8 = " + list8);
        System.out.println("----+- ge 9 = " + list9);


    }

    @Test
    public void gameSudoku() {
        List<Integer> ge1 = new ArrayList<>();
        List<Integer> ge2 = new ArrayList<>();
        List<Integer> ge3 = new ArrayList<>();
        List<Integer> ge4 = new ArrayList<>();
        List<Integer> ge5 = new ArrayList<>();
        List<Integer> ge6 = new ArrayList<>();
        List<Integer> ge7 = new ArrayList<>();
        List<Integer> ge8 = new ArrayList<>();
        List<Integer> ge9 = new ArrayList<>();

        ge1 = rndList();
        ge2 = rndList();
        ge3 = rndList(); ge4 = rndList(); ge5 = rndList(); ge6 = rndList(); ge7 = rndList(); ge8 = rndList(); ge9 = rndList();

        System.out.println("-!!! ge 1 = " + ge1);
        System.out.println("-!!! ge 2 = " + compareLists(ge1,ge2));


        ge2 = retunClist(ge1, ge2, ge3, ge4, ge5, ge6, ge7, ge8, ge9);
        ge3 = retunClist(ge1, ge3, ge2, ge4, ge5, ge6, ge7, ge8, ge9);
        ge4 = retunClist(ge1, ge4, ge2, ge3, ge5, ge6, ge7, ge8, ge9);
        ge5 = retunClist(ge1, ge5, ge2, ge3, ge4, ge6, ge7, ge8, ge9);
        ge6 = retunClist(ge1, ge6, ge2, ge3, ge5, ge4, ge7, ge8, ge9);
        ge7 = retunClist(ge1, ge7, ge2, ge3, ge5, ge6, ge4, ge8, ge9);
        ge8 = retunClist(ge1, ge8, ge2, ge3, ge5, ge6, ge7, ge4, ge9);

        retunClist1(ge1, ge2, ge3, ge4, ge5, ge6, ge7, ge8, ge9);

        if (ge1.equals(ge2)) {
            ge2= compareLists(ge1,ge2);

        }
        if (ge1.equals(ge3)){
          ge3= compareLists(ge1,ge3);
        }
        if (ge1.equals(ge4)) {
            ge4= compareLists(ge1,ge4);
        }
        if (ge1.equals(ge5)) {
            ge5= compareLists(ge1,ge5);
        }
        if (ge1.equals(ge6)) {
            ge6= compareLists(ge1,ge6);
        }
        if (ge1.equals(ge7)) {
            ge7= compareLists(ge1,ge7);
        }
        if (ge1.equals(ge8)) {
            ge8= compareLists(ge1,ge8);
        }
        if (ge1.equals(ge9)) {
            ge9= compareLists(ge1,ge9);
        }
        System.out.println("----- ge 1 = " + ge1);
        System.out.println("----- ge 2 = " + ge2);
        System.out.println("----- ge 3 = " + ge3);
        System.out.println("----- ge 4 = " + ge4);
        System.out.println("----- ge 5 = " + ge5);
        System.out.println("----- ge 6 = " + ge6);
        System.out.println("----- ge 7 = " + ge7);
        System.out.println("----- ge 8 = " + ge8);
        System.out.println("----- ge 9 = " + ge9);

    }

}

