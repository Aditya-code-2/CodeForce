import java.util.*;
public class NumberOfSmaller {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count = 0;

        int n  = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

         int j = 0;

        for(int i = 0; i < m; i++){
            while(j < n && a[j] < b[i]){
                j++;
            }

            System.out.print(j + " ");
        }
        sc.close();
    }
    
}
