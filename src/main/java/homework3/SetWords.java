package homework3;

import java.util.*;

public class SetWords {
    public static void main (String [] args) {

        String [] set = { "dog", "cat", "rabbit", "delfin", "bird", "camel", "cat", "elephant", "dog", "cow",
                "delfin", "chicken", "dog"};

        List<String> list  = new ArrayList<>(Arrays.asList(set));
        System.out.println("Список животных:" +list );

        Set <String> uniqueWord = new TreeSet<String>();
        uniqueWord.addAll(Arrays.asList(set));
        System.out.println("Список уникальных животных: " + uniqueWord);

        Map <String, Integer> map = new HashMap<>();
        for (String word : set) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество каждого из животных:" +map);
        }
    }