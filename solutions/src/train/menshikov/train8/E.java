package train.menshikov.train8;

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
    class Pair {
        int i;
        int j;
        int wag;
        public Pair(int i, int j, int wag) {
            this.i = i;
            this.j = j;
            this.wag =wag;
        }
    }
    private void solve() {
        int n = nextInt();
        char[][] table = new char[n][n];
        int [][] step  = new int [n][n];
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            table[i] = next().toCharArray();
        }
        int startx =0, starty=0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (table[i][j] == '@') {
                    step[i][j] = 1;
                    startx = i;
                    starty = j;
                    list.add(new Pair(i,j,1));
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        int destx=0, desty=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] =='@' && (i!=list.get(0).i || j != list.get(0).j)) {
                    destx = i;
                    desty = j;
                }
            }
        }

        int index = 0;
        while(index < list.size()) {
            int i = list.get(index).i;
            int j = list.get(index).j;

            if (i-2>=0 && j -1 >=0 && step[i-2][j-1] == 0 && table[i-2][j-1] != '#') {
                step[i-2][j-1] = list.get(index).wag+1;
                list.add(new Pair(i-2, j-1, step[i-2][j-1]));
            }
            if (i-1>=0 && j -2 >=0 && step[i-1][j-2] == 0 && table[i-1][j-2] != '#') {
                step[i-1][j-2] = list.get(index).wag+1;
                list.add(new Pair(i-1, j-2, step[i-1][j-2]));
            }
            if (i-2>=0 && j+1<n && step[i-2][j+1] == 0 && table[i-2][j+1] != '#') {
                step[i-2][j+1] = list.get(index).wag+1;
                list.add(new Pair(i-2, j+1, step[i-2][j+1]));
            }
            if (i-1>=0 && j+2 <n && step[i-1][j+2] == 0 && table[i-1][j+2] != '#') {
                step[i-1][j+2] = list.get(index).wag+1;
                list.add(new Pair(i-1, j+2, step[i-1][j+2]));
            }
            if (i+1<n && j +2<n && step[i+1][j+2] == 0 && table[i+1][j+2] != '#') {
                step[i+1][j+2] = list.get(index).wag+1;
                list.add(new Pair(i+1, j+2, step[i+1][j+2]));
            }
            if (i+2<n && j +1<n && step[i+2][j+1] == 0 && table[i+2][j+1] != '#') {
                step[i+2][j+1] = list.get(index).wag+1;
                list.add(new Pair(i+2, j+1, step[i+2][j+1]));
            }
            if (i+2<n && j -1 >=0 && step[i+2][j-1] == 0 && table[i+2][j-1] != '#') {
                step[i+2][j-1] = list.get(index).wag+1;
                list.add(new Pair(i+2, j-1, step[i+2][j-1]));
            }
            if (i+1<n && j-2 >=0 && step[i+1][j-2] == 0 && table[i+1][j-2] != '#') {
                step[i+1][j-2] = list.get(index).wag+1;
                list.add(new Pair(i+1, j-2, step[i+1][j-2]));
            }
            index++;
        }

        if (step[destx][desty] == 0) {
            out.println("Impossible");
        } else {
            while(destx!=startx || desty!=starty) {
                if (destx - 2 >= 0 && desty - 1 >= 0 && step[destx][desty] - step[destx - 2][desty - 1] == 1) {
                    destx-=2;
                    desty-=1;
                } else if (destx - 1 >= 0 && desty - 2 >= 0 && step[destx][desty] - step[destx - 1][desty - 2] == 1) {
                    destx-=1;
                    desty-=2;
                } else if (destx - 2 >= 0 && desty +1 <n && step[destx][desty] - step[destx - 2][desty +1] == 1) {
                    destx-=2;
                    desty+=1;
                } else if (destx - 1 >= 0 && desty + 2 <n && step[destx][desty] - step[destx - 1][desty + 2] == 1) {
                    destx-=1;
                    desty+=2;
                } else if (destx + 1 <n && desty - 2 >= 0 && step[destx][desty] - step[destx + 1][desty - 2] == 1) {
                    destx+=1;
                    desty-=2;
                } else if (destx + 1 <n && desty + 2 <n && step[destx][desty] - step[destx + 1][desty + 2] == 1) {
                    destx+=1;
                    desty+=2;
                } else if (destx + 2 <n && desty - 1 >= 0 && step[destx][desty] - step[destx +2][desty - 1] == 1) {
                    destx+=2;
                    desty-=1;
                } else if (destx +2 <n && desty +1<n && step[destx][desty] - step[destx +2][desty +1] == 1) {
                    destx+=2;
                    desty+=1;
                }
                table[destx][desty] = '@';
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(table[i][j]);
                }
                out.println();
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

