import java.util.*;
public class ggl{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        

        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
             
            int maxTotal = Integer.MIN_VALUE;
            //Arrays.sort(a);
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    int m = a[j];
                    int msft = a[k];
                    int gl = m-msft;
                    int sum = m + gl;

                     maxTotal = Math.max(maxTotal, sum);
                }
                
            }
            System.out.println(maxTotal);

            /*for(int j = 1; j < n; j++){
                
                     int m = a[j];
                     int msft = a[j-1];
                     int ggl1 = m - msft;
                     

                    int sum = m + ggl1;

                    maxTotal = Math.max(maxTotal, sum);
      
            }*/
            
            
        }
        sc.close();

    }
}