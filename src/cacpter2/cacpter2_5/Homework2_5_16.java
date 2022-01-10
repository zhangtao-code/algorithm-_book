package cacpter2.cacpter2_5;

import java.util.LinkedHashMap;
import java.util.Map;

public class Homework2_5_16 {
    public Map<Character, Integer> map;

    public Homework2_5_16(Map<Character, Integer> map) {
        this.map = map;
    }

    public static void main(String[] args) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < 26; i++) {
            int value = 'z' - i;
            char c = (char) value;
            map.put(c, 0 + i);
        }
        String[] array = {"sad", "sda", "sdasd", "wqew", "ryter"};
        map.forEach((key, value) -> System.out.println(key + "\t" + value));
        Homework2_5_16 temp = new Homework2_5_16(map);
        temp.sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                int compare = compareString(array[j], array[j - 1]);
                if (compare < 0) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public void swap(String[] array, int i, int j) {
        String value = array[i];
        array[i] = array[j];
        array[j] = value;
    }


    public int compareString(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            int compare = map.get(s1.charAt(i)) - map.get(s2.charAt(i));
            if (compare > 0) {
                return compare;
            } else if (compare < 0) {
                return compare;
            }
        }
        return s1.length() - s2.length();
    }
}
