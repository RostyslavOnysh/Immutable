package Immutable.muttableAndHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // HashMap and mutable objects example

        Map<User, List<String>> usersFavouriteSubjects = new HashMap<>();

        User bob = new User("Bob", "Alison", 23);
        usersFavouriteSubjects.put(bob, List.of("Math", "Chemistry"));
        System.out.println(usersFavouriteSubjects.get(bob));
        bob.setAdress(new Address("Shevchenka", 26));
        System.out.println(usersFavouriteSubjects.get(bob));


    }
}
