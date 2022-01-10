package cacpter2.cacpter2_5;

public class Homework2_5_15 {
    public static void main(String[] args) {
        String[] array = {"www@baidu.com", "www@sohu.com","rd@sohu.com", "www@taobao.cn", "www@taobd.cn", "rd@taobd.cn"};
        Homework2_5_15 temp = new Homework2_5_15();
        temp.sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                int compare = compareDomain(array[j], array[j - 1]);
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

    public int compareDomain(String s1, String s2) {
        String[] s1Array = s1.split("\\.");
        String[] s2Array = s2.split("\\.");
        int s1Index = s1Array.length - 1;
        int s2Index = s2Array.length - 1;
        while (s1Index >= 0 && s1Index >= 0) {
            String temp1 = s1Array[s1Index--];
            String temp2 = s2Array[s2Index--];
            int compare = compareString(temp1, temp2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
        }
        return s1Array.length - s2Array.length;
    }

    public int compareString(String s1, String s2) {
        int index = -1;
        if ((index = s1.indexOf("@")) >= 0) {
            s1 = s1.substring(index + 1);
        }
        if ((index = s2.indexOf("@")) >= 0) {
            s2 = s2.substring(index + 1);
        }
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
