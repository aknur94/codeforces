package rounds.div2_631;

import javafx.util.Pair;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long a[] = new long[n];
            for (int j = 0; j < n; j++) {
                a[j]=in.nextLong();
            }
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            long[] sum = new long[n];
            long[] len = new long[n];
            sum[0] = a[0];
            set.add(a[0]);
            len[0] = set.size();
            for (int j = 1; j < n; j++) {
                set.add(a[j]);
                len[j] = set.size();
                sum[j] = sum[j-1]+a[j];
            }
            Set<Long> set2 = new HashSet<>();
            long[] sum2 = new long[n];
            long[] len2 = new long[n];
            sum2[n-1] = a[n-1];
            set2.add(a[n-1]);
            len2[n-1] = set2.size();
            for (int j = n-2; j >=0 ; j--) {
                set2.add(a[j]);
                sum2[j] = sum2[j+1] + a[j];
                len2[j] = set2.size();
            }

            for (int j = 0; j < n; j++) {
                if ((calculate(len[j]) == sum[j]) && (calculate(len2[j+1]) == sum2[j+1])){
                    ans.add(new Pair(j+1, n-j-1));
                }
            }

            System.out.println(ans.size());
            for (int j = 0; j < ans.size(); j++) {
                System.out.println(ans.get(j).getKey() + " " + ans.get(j).getValue());
            }
        }
    }

    private static long calculate(long n) {
        return  (long)(n*1.0 * (n+1) / 2f);
    }
}
