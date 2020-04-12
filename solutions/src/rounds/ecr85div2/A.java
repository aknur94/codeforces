package rounds.ecr85div2;

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
        int t =nextInt();
        for (int q = 0; q < t; q++) {
            int n = nextInt();
            int p[] = new int[n];
            int c[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = nextInt();
                c[i] = nextInt();
            }
            boolean isout =false;
            for (int i = 1; i < n; i++) {
                if (p[i]<p[i-1]) {
                    System.out.println("NO");
                    isout = true;
                    break;
                }
                if (c[i]<c[i-1]) {
                    System.out.println("NO");
                    isout = true;
                    break;
                }
            }
            if (isout) continue;
            for (int i = 0; i < n; i++) {
                if (c[i]>p[i]) {
                    System.out.println("NO");
                    isout = true;
                    break;
                }
            }
            if (isout) continue;
            for (int i = 1; i < n; i++) {
                int difP = p[i] - p[i-1];
                int difC = c[i] - c[i-1];
                if (difC>difP) {
                    System.out.println("NO");
                    isout = true;
                    break;
                }
            }
            if (isout) continue;
            System.out.println("YES");
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

