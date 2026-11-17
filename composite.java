
import java.util.*;

public class composite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            // Constraint: 1 <= n <= 100
            if (n < 1 || n > 100) {
                continue;
            }

            if (n < 4) {
                System.out.println(-1);
                continue;
            }

            int[] p = new int[n];

            p[0] = 4;
            p[1] = 2;
            p[2] = 3;
            p[3] = 1;

            for (int i = 4; i < n; i++) {
                p[i] = i + 1;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(p[i] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
