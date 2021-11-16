package cacpter1;

public class Homework1_1_9 {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            if (!Integer.toBinaryString(i).equals(toBinary(i))) {
                System.out.println(i + "\twrong\t" + Integer.toBinaryString(i) + "\t" + toBinary(i));
            }
        }
    }

    public static String toBinary(int value) {
        String result = "";
        while (value > 1) {
            result = value % 2+result;
            value = value / 2;
        }
        if (value != 0) {
            return value + result;
        } else {
            return result;
        }

    }
}
