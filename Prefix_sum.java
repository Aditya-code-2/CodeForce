import java.util.*;
public class Prefix_sum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

       
            int n = sc.nextInt();
            long[] a = new long[n];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextLong();
            }
            long[] prefixSum = new long[n];
            prefixSum[0] = a[0];

            for(int i = 1; i < n; i++){
                prefixSum[i] = prefixSum[i-1] + a[i];

            }
            for(int i = 0; i < n; i++){
                System.out.print(prefixSum[i] + " ");
            }
            System.out.println();
        
        sc.close();
        
    }
}