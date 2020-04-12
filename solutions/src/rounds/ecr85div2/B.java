package rounds.ecr85div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int n = nextInt();
            int x = nextInt();
            long a[] = new long[n];
            long kazna = 0;
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
                if (a[i]>x){
                    kazna+=a[i]-x;
                    a[i] = x;
                }
            }
            Arrays.sort(a);
            for (int i = a.length-1; i >=0 ; i--) {
                if (a[i]<x) {
                    long dif = x - a[i];
                    if (dif>kazna) break;
                    a[i] = x;
                    kazna-=dif;
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (a[i]>=x) res++;
            }
            System.out.println(res);
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

