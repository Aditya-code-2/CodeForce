import java.util.*;

public class stubbornPen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            String s = in.next();

            int ch = 'R';
            int res = 0;

            for(int start = 0; start < n; start++){
                if(ch != s.charAt(start)){
                    res++;
                    ch = s.charAt(start);
                }
                if(ch == 'R'){
                    ch = 'B';
                }else{
                    ch = 'R';
                }
            }
            System.out.println(res);

        }
        in.close();
    }
    
}
