package train.menshikov.train6;

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
        char map[][] = new char[n+2][n+2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                map[i][j] = '#';
            }
        }
        for (int i = 0; i < n; i++) {
            String s = next();
            for (int j = 1; j <= n; j++) {
                map[i+1][j] = s.charAt(j-1);
            }
        }
        int res = count(1,1,map) + count(n, n, map);
        res-=4;
        System.out.println(res*9);
    }

    private int count(int i, int j, char[][] map) {
        if (map[i][j] != '.') return 0;
        map[i][j] = '$';
        int res = 0;
        if (map[i-1][j]=='#') res++;
        if (map[i+1][j]=='#') res++;
        if (map[i][j-1]=='#') res++;
        if (map[i][j+1]=='#') res++;
        return res + count(i-1,j,map) + count(i+1,j,map) + count(i, j-1, map) + count(i, j+1, map);
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

