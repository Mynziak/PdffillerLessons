package otherTests.blackJak;



import java.util.Scanner;
import java.util.*;

/**
 * Created by Dima on 12.04.2016.
 */
public class BlackJackNew {
    List<String> coloda = new LinkedList<String>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "1"));

    public void main(String[] args) throws InterruptedException {
     game();
        yn();
        //generateRandomCard();

    }


    public static String generateRandomCard(List<String> list) {
        Random random = new Random();
        String randomCard1 = list.get(random.nextInt(list.size()));
        list.remove(randomCard1);
        return randomCard1;
    }


    public void yn() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Continue?[Y/N]");
        String name = sc.nextLine();
        System.out.println(" name   " + name);
    }


    public List<String> updateColoda(String card, List<String> coloda) {

        for (int i = 0; i < coloda.size(); i++) {
            String tempName = coloda.get(i);
            if (tempName.equals(card)) {
                coloda.remove(i);
            }
        }

        return coloda;
    }


    public Integer getSummResult(List<String> list) {
        String firstCard = list.get(0);
        String secondCard = list.get(1);
        int result1 = Integer.parseInt(firstCard);
        int result2 = Integer.parseInt(secondCard);
        return result1 + result2;
    }





    //@Test
    public void game() throws InterruptedException {
        System.out.println("Full coloda is   " + coloda);
        Random random = new Random();
        String randomCard1 = coloda.get(random.nextInt(coloda.size()));
        coloda.remove(randomCard1);
        System.out.println("Your Card  is    " + randomCard1);

        System.out.println(coloda);
        String computerFirstCard = coloda.get(random.nextInt(coloda.size()));
        System.out.println("Computer's card is  " + computerFirstCard);
        coloda.remove(computerFirstCard);
        System.out.println(coloda);
        yn();

    }

}
