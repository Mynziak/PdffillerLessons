package otherTests;

import java.util.*;

/**
 * Created by Dima on 05.04.2016.
 */
public class CollectionsLesson {

    /* ��������� ���� ��������
1. ������ ������ Solution ������� public static ������ Cat, Dog.
2. ����������� ����� createCats, �������� ������ ���������� ��������� � 4 ������.
3. ����������� ����� createDogs, �������� ������ ���������� ��������� � 3 ��������.
4. ����������� ����� join, �������� ������ ���������� ������������ ��������� ���� �������� - ���� ����� � �����.
5. ����������� ����� removeCats, �������� ������ ������� �� ��������� pets ���� �����, ������� ���� � ��������� cats.
6. ����������� ����� printPets, �������� ������ �������� �� ����� ���� ��������, ������� � ��� ����. ������ �������� � ����� ������
*/

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static class Cat {
        String name;

        public Cat(String catName) {

            this.name = catName;
        }

        public Cat() {
        }

        // We should to overwrite it, because it returs object, not string! or if you want to make sout cat name use cat.name
        @Override
        public String toString() {
            return "CatName = " + name;
        }
    }

    public static class Dog {
        String name;

        public Dog(String dogName) {
            this.name = dogName;
        }

        public Dog() {
        }

        @Override
        public String toString() {
            return "DogName = " + name;
        }
    }


    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat("cat1"));
        cats.add(new Cat("cat2"));
        cats.add(new Cat("cat3"));
        // why  system souts a lot of cats????
        for (Cat s : cats) {
            System.out.println("Added Cats:    " + s);
        }

        return cats;
    }

    public static Set<Dog> createDogs() {

        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("dog1"));
        dogs.add(new Dog("dog2"));
        dogs.add(new Dog("dog3"));
        dogs.add(new Dog("dog4"));
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);

        for (Object p : pets) {
            System.out.println("Joined Sets here:   "+ p);
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {

        System.out.println("remove all pets +    "+ pets.removeAll(cats));
    }

    public static void printPets(Set<Object> pets) {

        for (Object s : pets) {
            System.out.println("Print all pets here:    "+s);
        }
    }

}

