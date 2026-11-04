import java.util.*;

public class NumbersOnTheBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int n = r - l + 1;

            int neg = Math.max(0, -l);
            int pos = Math.max(0, r);

            int zero = (l <= 0 && r >= 0) ? 1 : 0;

            int keep = 2 * Math.min(neg, pos) + zero;

            if (neg != pos) {
                keep++;
            }

            System.out.println(n - keep);
        }

        sc.close();
    }
}