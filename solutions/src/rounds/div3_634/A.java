package rounds.div3_634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new A().run();
    }

    private void solve() {
        int t = nextInt();
        for (int q = 0; q < t; q++) {
            long n = nextLong();
            out.println(n%2==0?(n/2)-1:n/2);
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

