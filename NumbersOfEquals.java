import java.util.*;

public class NumbersOfEquals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int[] b = new int[m];
        for(int j = 0; j < m; j++){
            b[j] = sc.nextInt();
        }

        int i = 0, j = 0;
        long count = 0;

        while(i < n && j < m){
            if(a[i] < b[j]){
                i++;
            }
            else if(a[i] > b[j]){
                j++;
            }
            else{
                int x = a[i];
                int firstCount = 0, secondCount = 0;

                while(i < n && a[i] == x){
                    firstCount++;
                    i++;
                }

                while(j < m && b[j] == x){
                    secondCount++;
                    j++;
                }

                count += (long)firstCount * secondCount;
            }
        }

        System.out.println(count);
        sc.close();
    }
}