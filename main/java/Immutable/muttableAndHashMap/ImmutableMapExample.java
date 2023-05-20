package Immutable.muttableAndHashMap;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, String> coutriesCapitals = new HashMap<>();
        String ukraine = "Ukraine";
        coutriesCapitals.put(ukraine,"Kyiv");
        System.out.println(coutriesCapitals.get(ukraine));
        ukraine.toUpperCase();
        System.out.println(coutriesCapitals.get(ukraine));
    }
}
