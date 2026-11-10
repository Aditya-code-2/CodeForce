
import java.util.*;

public class SegmentWithSmallSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long s = sc.nextLong();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int i = 0, res = 0;
        long sum = 0;

        for (int j = 0; j < n; j++) {
            sum += a[j];

            while (sum > s) {
                sum -= a[i];
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        System.out.println(res);
        sc.close();
    }
}
