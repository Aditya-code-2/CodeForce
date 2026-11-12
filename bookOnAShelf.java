
import java.util.*;

public class bookOnAShelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i == 0 || a[i] != a[i - 1]) {
                    ans.add(a[i]);
                }
            }

            int k = ans.size();

            // Remaining elements in descending order
            for (int i = n - 1; i >= 0; i--) {
                if (i > 0 && a[i] == a[i - 1]) {
                    ans.add(a[i]);
                }
            }

            System.out.println(k + (n > k ? 1 : 0));

            for (int x : ans) {
                System.out.print(x + " ");
            }

            System.out.println();
        }
    }
}
