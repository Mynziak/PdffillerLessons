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
������: ������� � ���������� ������ �� ��� ��� ���� �� ����� ������� ������ ������, ����� ���� ������� ������ � ��������������� ������� (����������)*/


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

    sort(list); //����� ��� ���������� ������

    //������� ������ � ��������������� �������
}

    public static void sort(List<String> list) {
        //���������� ���� �������� ���������� ������ ��� ������  ������ isGreaterThan(String a, String b)
    }

    //����� ��� ��������� �����: '�' ������ ��� 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
