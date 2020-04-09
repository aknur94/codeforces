package rounds.div2_632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Template {

    private void solve() {
        int n = nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        boolean isGood[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            isGood[i] = true;
        }
        long[] sum = new long[n];
        long res = 0;
        long falseIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0 && isGood[j]; j--) {
                sum[j]+=a[i];
                if (sum[j]==0) {
                    isGood[j]=false;
                    falseIndex = j+1;
                    break;
                }
            }
            /*
            for (int j = i; j >=0 && isGood[j] ; j--) {

                res++;
            }
            */
            if (i==falseIndex) res++;
            else res+=i-falseIndex+1;
        }
        out.println(res);
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new Template().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

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