import java.util.*;
public class Lock_Unlock{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        

        while(t-- > 0){
            long count = 0;
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i< n; i++){
                a[i] = sc.nextInt();
                
            }
            Arrays.sort(a);
            int median = a[n/2];
            for(int num : a){
                count += Math.abs(num - median);// minimum number of cost
            }
            long positive = a[n - 1] - median;
            long negative = median - a[0];

            long operations = positive + negative;// minimum number of operations

            System.out.println(count + " " + operations);

        }
        sc.close();
      

    }


}