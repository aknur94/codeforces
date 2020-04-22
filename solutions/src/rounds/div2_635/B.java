package rounds.div2_635;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new B().run();
    }

    private void solve() {
        int t = nextInt();
        for (int q = 0; q < t; q++) {
            int x = nextInt();
            int n = nextInt();
            int m = nextInt();
            int an = x/2 + 10;
            while(x > an && n > 0) {
                x = an;
                n--;
                an = x/2 + 10;
            }
            x-= m*10;
            if (x>0) {out.println("NO");}
            else out.println("YES");
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

