package otherTests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 07.04.2016.
 */
public class CollectionHomeWork2 {
    /*
Задача: Вводить с клавиатуры строки до тех пор пока не будет введена пустая строка, после чего вывести строки в отсортированном порядке (алфавитном)*/


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String stroka=reader.readLine();

        while (!stroka.equals("")){
           stroka=reader.readLine();
           list.add(stroka);
        }

        for (String s : list) {
            System.out.print(s);
        }

    sort(list); //метод для сортировки списка

    //вывести список в отсортированном порядке
}

    public static void sort(List<String> list) {
        //реализуйте свой алгоритм сортировки списка при помощи  метода isGreaterThan(String a, String b)
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
