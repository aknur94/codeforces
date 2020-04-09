package train.menshikov.train7;

import javafx.util.Pair;

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

    public static void main(String[] args) {
        new E().run();
    }

    private void solve() {
        int n = nextInt();
        char a[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        char from[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                from[i][j] = '.';
            }
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean broken = false;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    list.add(new Pair<>(i,j));
                    from[i][j] = 'X';
                    broken = true;
                    break;
                }
            }
            if (broken) break;
        }
        int index = 0;
        boolean hasAnswer = false;
        while(index < list.size()) {
            int i = list.get(index).getKey();
            int j = list.get(index).getValue();
            if (a[i][j] == '@') {
                show(from, a, i, j);
                hasAnswer = true;
                break;
            }
            if (i-1>=0 && a[i-1][j] != 'O' && from[i-1][j] == '.') {
                list.add(new Pair<>(i-1, j));
                from[i-1][j] = 'u';
            }
            if (i+1<n && a[i+1][j] != 'O' && from[i+1][j] == '.') {
                list.add(new Pair<>(i+1, j));
                from[i+1][j] = 'd';
            }
            if (j+1<n && a[i][j+1] != 'O' && from[i][j+1] == '.') {
                list.add(new Pair<>(i, j+1));
                from[i][j+1] = 'r';
            }
            if (j-1>=0 && a[i][j-1] != 'O' && from[i][j-1] == '.') {
                list.add(new Pair<>(i, j-1));
                from[i][j-1] = 'l';
            }
            index++;
        }
        if (!hasAnswer) out.println("N");
    }

    private void show(char[][] from, char[][] a, int i, int j) {
        while(true) {
            if (from[i][j] == 'u'){
                ++i;

            } else if (from[i][j] == 'd'){
                --i;

            } else if (from[i][j] == 'r'){
                --j;

            } else if (from[i][j] == 'l'){
                ++j;

            }
            if (a[i][j] == 'X') {
                a[i][j] = '+';
                break;
            }
            a[i][j] = '+';
        }
        out.println("Y");
        for (int k = 0; k < a[0].length; k++) {
            for (int l = 0; l < a[0].length; l++) {
                System.out.print(a[k][l]);
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
}

