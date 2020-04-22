package rounds.div3_634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E1 {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new E1().run();
    }

    private void solve() {
        int t = nextInt();
        for (int q = 0; q < t; q++) {
            int n = nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            int res = n;

            for (int i = 0; i < n; i++) {
                int aValue = a[i];
                int aLen = 1;
                int bValue = -1;
                int bLen = -1;
                for (int j = i+1; j < n; j++) {
                    if(a[j]==a[i] && bValue ==-1) {
                        aLen++;
                    } else if (a[j]!=a[i] && bValue ==-1) {
                        bValue = a[j];
                        bLen = 1;
                    } else if (a[j]!=a[i] && a[j] == bValue) {
                        bLen++;
                    }
                }
            }
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

