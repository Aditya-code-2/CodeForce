import java.util.*;


public class StakesAndShapesDiv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int n = a + b + c;
            char moves;

            if (b >= c) {
                moves = 'R';
            }
            else if (c >= a) {
                moves = 'S';
            }
            else {
                moves = 'P';
            }
             StringBuilder ans = new StringBuilder();

            for (int i = 0; i < n; i++) {
                ans.append(moves);
            }

            System.out.println(ans);
        }

        sc.close();
        
        
    }
}