import java.util.*;
public class threePiles
{
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while(t-- > 0)
        {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            int[] arr = new int[]{a, b, c};
            if(arr[1] - arr[0] == 1 &&
                arr[2] - arr[1] == 1
            ){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
        input.close();

        
    }

}