package otherTests.blackJak;

/**
 * Created by Dima on 12.04.2016.
 */
public class Card {

    int value;
    String lear;

    public Card(int value, String lear) {

        this.lear = lear;
        this.value = value;
    }


    @Override
    public String toString() {
        return "Card: " + value + " lear=" + lear;
    }

}
