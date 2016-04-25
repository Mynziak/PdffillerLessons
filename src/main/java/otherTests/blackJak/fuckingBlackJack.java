package otherTests.blackJak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Dima on 19.04.2016.
 */
public class fuckingBlackJack {


    public static final class Card{

        private enum Rank{
            //ACE has a special value, the default is one, but if the value being added to ace is < 11, ACE is an 11
            ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
            EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

            private final int value; //represents the value of some card
            /**
             * Sets the value of a rank
             * @param {@code int}
             */
            Rank(int value){
                this.value = value;
            }
        }
        private enum Suit{
            CLUBS, HEARTS, DIAMONDS, SPADES;
        }

        private final Rank cardRank; //The rank of the card
        private final Suit cardSuit; //The suit of the card

        /**
         * valueOf -- static factory, creates a card by using the private
         * constructor to initialize a card based on an {@code int}
         * @return {@code Card}
         * @param {@code int}
         */
//        public static Card valueOf(int num){
//            int suitNum = num % 4;
//            int rankNum = num % 13;
//            Rank[] ranks = Rank.values();
//            Suit[] suits = Suit.values();
//            Card c = new Card(ranks[rankNum], suits[suitNum]);
//            return c;
//        }

        /**
         * Constructor for creating a Card object. Uses a Rank and Suit to
         * initialize the number. Private constructor, it is only used in
         * the static factory method.
         */
        private Card(Rank cardRank, Suit cardSuit){
            this.cardRank = cardRank;
            this.cardSuit = cardSuit;
        }

        /**
         * Overridden equals -- uses the design established in Effective
         * Jave, first tests whether the argument is identical to this,
         * if it is, it can obviously return true
         * {@code String s = "h"; String b = s; s.equals(b) == true}
         * next the code tasts if the object is actually a Card, it it
         * isn't, it's easy to realize that the two items being compared
         * cannot be equal. A String will never be equal to an Integer.
         * Since we previously tested the type of o, it's safe to case o
         * to type Card, and give a reference to it. Finally, compare the
         * enum constants of the card, only is both the rank and suit of
         * this is equal to the rank and suit of o(or c), will true be
         * returned
         * @return {@code boolean} -- true if this.equals(o), else false
         * @param {@code Object} -- item to be compared to this
         */
        @Override public boolean equals(Object o){
            if(this == o)
                return true;
            if(!(o instanceof Card))
                return false;
            Card c = (Card) o;
            return cardRank.equals(c.cardRank) && cardSuit.equals(c.cardSuit);
        }

    }

    public static void main(String[] args) throws Exception {

        Set<Card> deck = new HashSet<Card>();



        List<String> coloda = new LinkedList<String>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "1"));
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


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input ;
        System.out.print("\nWould you like to continue? (Y or y)  \n");
        input = reader.readLine();

        if (input.equals("y")){
            String randomCard2 = coloda.get(random.nextInt(coloda.size()));
            System.out.println(randomCard2);
            coloda.remove(randomCard2);
            System.out.println(coloda);
        } else {
            // count summ of card and sout result
        }

    }

    public static void generateRandomCard(List<String> list) {

    }


    public static String ynB(List<String> list, Random random) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input ;


            System.out.print("\nWould you like to continue? (Y or y)  \n");
            input = reader.readLine();
        if (input.equals("y")){
            String randomCard1 = list.get(random.nextInt(list.size()));

        }
        return input;
    }



}
