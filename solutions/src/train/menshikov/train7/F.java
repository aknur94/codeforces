package train.menshikov.train7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new F().run();
    }

    private void solve() {
        int n = nextInt();
        int m = nextInt();
        char [][] c = new char[n+2][m+2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                c[i][j] = '.';
            }
        }
        for (int i = 0; i < n; i++) {
            String s = next();
            for (int j = 1; j <=m ; j++) {
                c[i+1][j] = s.charAt(j-1);
            }
        }
        int res = 0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (c[i][j]=='#') {
                    res++;
                    dfs(i,j,c);
                }
            }
        }
        out.println(res);
    }

    private void dfs(int i, int j, char[][] c) {
        if (c[i][j] == '.') return;
        c[i][j]='.';
        dfs(i-1,j,c);
        dfs(i+1,j,c);
        dfs(i,j-1,c);
        dfs(i,j+1,c);
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

