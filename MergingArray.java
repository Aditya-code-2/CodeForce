
import java.util.*;
public class MergingArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[m+n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        int i = 0, j = 0;
        while(i < n || j < m){
            if(j == m || (i < n && a[i] <= b[j])){
                c[i+j] = a[i];
                i++;
            }else{
                c[i+j] = b[j];
                j++;
            }
        }
        for(int k = 0; k < c.length; k++){
            System.out.print(c[k]+" ");
        }
        sc.close();

    }
}