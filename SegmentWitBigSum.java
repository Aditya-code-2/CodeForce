import java.util.*;
public class SegmentWitBigSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();

        long[] a = new long[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }

        int i = 0;
        
        long sum = 0;
        int res = n+1;
        for (int j = 0; j < n; j++) {
            sum += a[j];

            while(sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= a[i];
                i++;
            }

            
        }

        System.out.println(res == n+1 ? -1 : res);
        sc.close();
    }
    
}