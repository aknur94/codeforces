package rounds.div3_634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new D().run();
    }

    private void solve() {
        int t = nextInt();
        for (int q = 0; q < t; q++) {
            char[][] a= new char[9][9];
            for (int i = 0; i < 9; i++) {
                a[i] = next().toCharArray();
            }
            int index = 0;
            for (int i = 0; i < 9; i++) {
                int x = (index*3)%9 + i/3;
                a[i][x] = a[i][(x+1)%9];
                index++;
            }
            for (int i = 0; i < 9; i++) {
                out.println(a[i]);
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

