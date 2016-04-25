//package otherTests.blackJak;
//
//import org.testng.annotations.Test;
//
//import java.util.*;
//
///**
// * Created by Dima on 08.04.2016.
// */
//public class BlackJackTest {
//
//
//    List<String> coloda = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "1");
//
//    Set <String> coloda = new HashSet(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "1"));
//
//
//    public static Set<String> generate2Cards(Random rng, List<String> list) {
//
//        String randomCard1 = list.get(rng.nextInt(list.size()));
//        String randomCard2 = list.get(rng.nextInt(list.size()));
//        Set<String> twoCards;
//
//        if (!randomCard1.equals(randomCard2)) {
//            twoCards = Arrays.asList(randomCard1, randomCard2);
//        } else {
//            while (randomCard1.equals(randomCard2)) {
//                randomCard1 = list.get(rng.nextInt(list.size()));
//            }
//            twoCards = Arrays.asList(randomCard1, randomCard2);
//        }
//        return twoCards;
//    }
//
//    public Integer getSummResult(List<String> list) {
//        String firstCard = list.get(0);
//        String secondCard = list.get(1);
//        int result1 = Integer.parseInt(firstCard);
//        int result2 = Integer.parseInt(secondCard);
//        return result1 + result2;
//    }
//
//    public void updatedColoda(List<String> oldColoda, List<String> twoCards) {
//        for (int i = 0; i < oldColoda.size(); i++) {
//            if (oldColoda.get(i) == twoCards.get(0) || oldColoda.get(i) == twoCards.get(1)) {
//                oldColoda.remove(oldColoda.get(i));
//            }
//
//          List<String> updatedColoda = oldColoda;
//
//
//        }
//
//        List<String> updatedColoda = new ArrayList<String>(oldColoda);
//
////        for (Iterator<String> iter = oldColoda.listIterator(); iter.hasNext(); ) {
////            String a = iter.next();
////            if (a == twoCards.get(0) || a == twoCards.get(1)) {
////                iter.remove();
////            }
//    }
//
//
//    @Test
//    public void game() {
//        Random random = new Random();
//        List<String> givenCards;
//        givenCards = generate2Cards(random, coloda);
//        System.out.println(generate2Cards(random, coloda));
//        int summCards = getSummResult(givenCards);
//        if (summCards == 21) {
//            System.out.println("!!!User Win!!!");
//        } else {
//            // return 1 cards from updated coloda
// updatedColoda(coloda, givenCards);
//        }
//
//
//    }
//
//
//}
//
//
