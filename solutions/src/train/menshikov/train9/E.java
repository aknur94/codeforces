package train.menshikov.train9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        new E().run();
    }

    private void solve() {

        int n = nextInt();

        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }

        int b[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    b[i][j] = a[i][j];
                } else {
                    bfs(a, b, i, j);
                }
            }
        }
        for (int k = 0; k < a.length; k++) {
            for (int l = 0; l < a.length; l++) {
                out.print(b[k][l] + " ");
            }
            out.println();
        }
    }

    private void bfs(int[][] a, int[][] b, int i, int j) {
        List<Pair> list = new ArrayList<>();
        List<Integer> listR = new ArrayList<>();
        list.add(new Pair(i, j, 0));
        int index = 0;
        int bigStep = 1;
        boolean bool[][] = new boolean[a.length][a.length];
        bool[i][j] = true;
        while (index < list.size()) {
            int step = list.get(index).step + 1;
            if (bigStep != step) {
                bigStep = step;
                int res = 0;
                int count = 0;
                for (int p :
                        listR) {
                    if (p > 0) {
                        count++;
                        res = p;
                    }
                }
                if (count > 1) {
                    b[i][j] = 0;
                    listR.clear();
                    return;
                } else if (count == 1) {
                    b[i][j] = res;
                    return;
                }
            }
            for (int k = 0; k < 4; k++) {
                int x = list.get(index).i + d[k][0];
                int y = list.get(index).j + d[k][1];
                if (x >= 0 && x < a.length && y >= 0 && y < a.length && !bool[x][y]) {
                    list.add(new Pair(x, y, step));
                    listR.add(a[x][y]);
                    bool[x][y] = true;
                }
            }
            index++;
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

    class Pair {
        int i;
        int j;
        int step;

        public Pair(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }
}

