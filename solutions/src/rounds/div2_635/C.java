package rounds.div2_635;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public static void main(String[] args) {
        new C().run();
    }


    class City {
        List<City> child;
        int degree;
        int value;
        boolean isTuristic = true;
        public City(int value, List<City> child, int degree) {
            this.value = value;
            this.child = child;
            this.degree = degree;
        }
    }
    private void solve() {
        int n = nextInt();
        int k = nextInt();
        List<Integer> set[] = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            set[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt();
            set[a].add(b);
            set[b].add(a);
        }
        Iterator<Integer> it = set[1].iterator();
        City root = new City(1, Collections.emptyList(), 0);
        while (it.hasNext()){
            Integer v = it.next();
            root.child.add(new City(v, Collections.emptyList(), 1));
            set[v].remove(1);
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it2 = set[1].iterator();
        while(it2.hasNext()) {
            list.add(it2.next());
        }
        while (index<list.size()) {
            for (int i = 0; i <set[list.get(index)].size() ; i++) {

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

