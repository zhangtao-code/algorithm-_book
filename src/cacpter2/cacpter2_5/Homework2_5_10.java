package cacpter2.cacpter2_5;

public class Homework2_5_10 {
    public static void main(String[] args) {
        String[] array = {"a", "d", "u", "d", "d", "t"};
        array = new Homework2_5_10().sort(array);
        for (String s : array) {
            if (s == null) {
                break;
            }
            System.out.print(s + "\t");
        }
    }

    public String[] sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                int compare = compare(array[j - 1], array[j]);
                if (compare > 0) {
                    swap(array, j - 1, j);
                }
            }
        }
        String[] result = new String[array.length];
        result[0] = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (compare(array[i], array[i - 1]) != 0) {
                result[++index] = array[i];
            }
        }
        return result;
    }

    public void swap(String[] array, int i, int j) {
        String value = array[i];
        array[i] = array[j];
        array[j] = value;
    }

    public int compare(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            int compare = s1.charAt(i) - s2.charAt(i);
            if (compare > 0) {
                return compare;
            } else if (compare < 0) {
                return compare;
            }
        }
        return s1.length() - s2.length();
    }
}
