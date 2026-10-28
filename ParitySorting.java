import java.util.*;

public class ParitySorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
       
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            ArrayList<Long> oddPositions = new ArrayList<>();   
            ArrayList<Long> evenPositions = new ArrayList<>();  

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (i % 2 == 0) {
                    oddPositions.add(a[i]);  
                } else {
                    evenPositions.add(a[i]); 
                    
                }
            }

            oddPositions.sort(Collections.reverseOrder());
            
            Collections.sort(evenPositions);

            int oddidx = 0, evenidx = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sb.append(oddPositions.get(oddidx++)).append(" ");
                } else {
                    sb.append(evenPositions.get(evenidx++)).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}