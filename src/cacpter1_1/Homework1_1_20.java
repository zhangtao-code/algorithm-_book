package cacpter1_1;

public class Homework1_1_20 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"\t"+ln(i));
        }
    }

    public static int ln(int n) {
        return (int) Math.log(chengjie(n));
    }

    public static int chengjie(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * chengjie(n - 1);
    }
}
