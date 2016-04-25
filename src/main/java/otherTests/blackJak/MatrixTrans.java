package otherTests.blackJak;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by DM on 24.02.2016.
 */
public class MatrixTrans {

   // static int a = 4;
   // static int b = 4;


    public static void main(String[]args) throws InterruptedException {

        //ввод значения с клавиатуры
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Введи количество строк  ");
        int a = scanner.nextInt();

        System.out.println(" Введи количество столбиков  ");
        int b = scanner.nextInt();



        //объявялем матрицу
        int arA[][] = new int[a][b];
        int arTransp[][] = new int[b][a];

        //оригинальная матрица
        for(int i = 0; i< a;i++) {
            for(int j = 0; j < b; j++) {
                //arA[i][j] = i;

                arA[i][j] = scanner.nextInt(); // для ввода с клавиатуры

                System.out.print(arA[i][j] + "    ");
                Thread.sleep(1);
            }
            System.out.println();
        }

        System.out.println(" ");

        //транспонируем матрицу
        for(int i = 0; i< a;i++) {
            for(int j = 0; j < b; j++) {
                arTransp[j][i] = arA[i][j];
            }
        }

        //вывод результата
        for(int i = 0; i< b;i++) {
            for(int j = 0; j < a; j++){
                System.out.print(arTransp[i][j] + "    ");
            }
            System.out.println();
        }

        scanner.close();
        //закрыли поток считывания
    }
}
