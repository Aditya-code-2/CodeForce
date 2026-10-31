
import java.util.*;

public class MathAndPhysicsDiv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long sum = 0;
            boolean possible = false;
            boolean internal = false;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                sum += x;

                if (x >= 2) {
                    possible = true;

                    if (i > 0 && i < n - 1) {
                        internal = true;
                    }
                }
            }

            if (!possible) {
                System.out.println(-1);
            } else if (internal) {
                System.out.println(sum - 1);
            } else {
                System.out.println(sum - (n - 1));
            }
        }

        sc.close();
    }
}
