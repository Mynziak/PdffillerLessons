package otherTests;

/**
 * Created by DimaM on 10/22/2015.
 */
public class AnimalA {

    // method that execute when class is called
    public AnimalA() {
        value = 25;
    }
   protected int value;



    public AnimalA (int value){
        this.value =value; //this - ssilka v klasse samu na sebya, peremennaya v etom klasse

    }


    AnimalA a = new AnimalA();
    AnimalA a1 = new AnimalA (30);
}
