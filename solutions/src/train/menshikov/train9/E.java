package train.menshikov.train9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {

    static int n;
    static private int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new E().run();
    }

    private void solve() {
        int[][] a = new int[202][202];
        Pair[][][] pairs = new Pair[202][202][2];
        for (int i = 0; i < 202; i++) {
            for (int j = 0; j < 202; j++) {
                pairs[i][j][0] = new Pair(0,0,0);
                pairs[i][j][1] = new Pair(0,0,0);
            }
        }
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = nextInt();
                if (a[i][j]>0) {
                    pairs[i][j][0].i = i;
                    pairs[i][j][0].j = j;
                }
            }
        }
        boolean changed = true;

        int it = 0;
        while(changed) {
            changed=false;
            it++;
            for (int i = 1; i<=n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (pairs[i][j][it%2].i > 0 && pairs[i][j][it%2].j >0) {
                        pairs[i][j][Math.abs(it%2-1)].i = pairs[i][j][it%2].i;
                        pairs[i][j][Math.abs(it%2-1)].j = pairs[i][j][it%2].j;
                        continue;
                    }
                    Set<Pair> set = new HashSet<>();
                    Pair pair = pairs[i][j][it%2];
                    set.add(new Pair(0,0,1));
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (set.add(pairs[x][y][it%2])){
                            pair = pairs[x][y][it%2];
                        }
                    }
                    if (set.size()==2) {
                        pairs[i][j][Math.abs(it%2-1)] = pair;
                    } else if (set.size()==3) {
                        pairs[i][j][Math.abs(it%2-1)] = new Pair(201, 201,0);
                    }
                }
            }
            for (int k = 0; k < 202; k++) {
                for (int l = 0; l < 202; l++) {
                    if (!pairs[k][l][0].equals(pairs[k][l][1])) {
                        changed =true;
                        break;
                    }
                }
                if (changed) break;
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                out.print(a[pairs[i][j][0].i][pairs[i][j][0].j]+" ");
            }
            out.println();
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

    static class Pair {
        int i;
        int j;
        int step;

        public Pair(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}

