import org.testng.annotations.Test;

/**
 * Created by DimaM on 7/16/2015.
 */
public class ArrayLesson {


    public  int week[] = new int[7];

    int week1[] = {2, 3, 4};

    @Test(enabled = false)

    public void les1() {


    for(   int i = 0;    i<week.length;i++)

    {
        week[i]=i;
        System.out.println(week[i]);
    }
    }

    @Test(enabled = false)
    public void pizMet ()
    {
        for (int day:week1){
            day = 3;
            System.out.println(day);
        }

    }

    int month [] [] = new int [5][7];

    @Test(enabled = false)
    public void month ()
    {
        for (int i =0; i< 5; i ++)
        {
            for (int j =0; j<7; j++)

            {
                month[i][j]=i+j;
                System.out.print(month[i][j]);
            }
            System.out.println();

        }
    }







}

