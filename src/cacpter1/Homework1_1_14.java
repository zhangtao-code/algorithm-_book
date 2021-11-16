package cacpter1;

public class Homework1_1_14 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            int result = (int) (Math.log(i) / Math.log(2));
            if (lg(i) != result) {
                System.out.println(i + "\t" + lg(2));
            }
        }
    }

    /**
     * 求log2 N
     *
     * @param n
     * @return
     */
    public static int lg(int n) {
        int count = 0;
        while (n >= 2) {
            n = n >> 1;
            count++;
        }
        return count;
    }
}
