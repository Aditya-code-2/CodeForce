import java.util.*;

public class Fraction_Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            
            int n = sc.nextInt();
            int m = sc.nextInt();

            String p = sc.next();
            String q = sc.next();

            
            StringBuilder sb = new StringBuilder(p);
            boolean possible = true;

            for (int i = 0; i < m; i++) {
                char ch = q.charAt(i);
                int idx = sb.indexOf(String.valueOf(ch));
                if (idx != -1) {
                    sb.deleteCharAt(idx);
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
               
                if (sb.length() == 3) {
                    int countS = 0, countI = 0, countX = 0;
                    
                    for (int i = 0; i < sb.length(); i++) {
                        char c = sb.charAt(i);
                        if (c == 's') countS++;
                        else if (c == 'i') countI++;
                        else if (c == 'x') countX++;
                    }
                    
                    if (countS == 1 && countI == 1 && countX == 1) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}