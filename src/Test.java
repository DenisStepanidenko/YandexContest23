import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] test = new int[3];
        test[0] = 1;
        test[1] = 2;
        test[2] = 3;
        Arrays.fill(test , 7);
        System.out.println(Arrays.toString(test));
    }
}
