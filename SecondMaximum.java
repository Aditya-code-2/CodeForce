import java.util.*;

public class SecondMaximum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //number of test cases
       
        while(t-- > 0){
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++)
            {
                int num = sc.nextInt();
                if(num > max){
                    secondMax = max;
                    max = num;
                }
                else if(num > secondMax && num != max){
                    secondMax = num;
                }
            }
            System.out.println(secondMax);
        }
        sc.close();
    }

}