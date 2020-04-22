package rounds.div3_634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class С {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new С().run();
    }

    private void solve() {
        int t =nextInt();
        for (int q = 0; q < t; q++) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            int max = 0;
            int n = nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                int x= nextInt();
                set.add(x);
                if (map.get(x) == null) {
                    map.put(x, 1);
                    if (max < 1) {
                        max = 1;
                    }
                } else {
                    int y = map.get(x) + 1;
                    if (y>max) {
                        max = y;
                    }
                    map.put(x, y);
                }
            }
            out.println(Math.max(Math.min(max-1, set.size()), Math.min(max, set.size()-1)));
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    private Integer nextInt() {
        return Integer.parseInt(next());
    }

    private Long nextLong() {
        return Long.parseLong(next());
    }

    private Double nextDouble() {
        return Double.parseDouble(next());
    }
}

