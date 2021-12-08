package cacpter2.cacpter2_5;

public class Homework2_5_3 {
    public static void main(String[] args) {
        double d1 = 0.1d;
        double d2 = 0.2d;
        double d3 = 0.3d;
        System.out.println(d1 + d2 == d3);
        System.out.println(Double.doubleToLongBits(d1 + d2) == Double.doubleToLongBits(d3));
    }

}
