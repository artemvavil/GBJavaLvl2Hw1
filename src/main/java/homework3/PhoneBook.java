package homework3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {

    HashMap<String, String> phone = new HashMap<>();

    void add(String name, String number) {
        phone.put(name, number);
    }

    void get(String name) {
        Iterator<Map.Entry<String, String>> iterator = phone.entrySet().iterator();
        //boolean meaning = false;
        System.out.println("Для " + name + " соответствуют номера:");


    }
}