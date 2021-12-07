package cacpter2.cacpter2_5;

public class Homework2_5_2 {
    public static void main(String[] args) {
        String[] value = {"weq", "yhgujrt", "weqweqw", "reqwe", "weqw"};
        search(value);
    }

    public static void search(String[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (compare(array[j - 1], array[j]) > 0) {
                    swap(array, j-1, j);
                }
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                String value = subString(array[i], array[j]);
                if (value == null) {
                    break;
                }
                int index = binarySearch(array, value);
                if (index >= 0 && index != i) {
                    System.out.println(array[i] + "\t" + array[index] + "\t" + array[j] + "\t");
                    break;
                }
            }
        }
    }

    public static int binarySearch(String[] array, String value) {//二分法,保证数据不会重复
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int compare = compare(array[mid], value);
            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static String subString(String s1, String s2) {
        if (s2.length() <= s1.length()) {
            return null;
        }
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) - s2.charAt(i) != 0) {
                return null;
            }
        }
        return s2.substring(length);
    }

    public static void swap(String[] array, int i, int j) {
        String value = array[i];
        array[i] = array[j];
        array[j] = value;
    }

    public static int compare(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            int compare = s1.charAt(i) - s2.charAt(i);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
        }
        return s1.length() - s2.length();
    }
}
