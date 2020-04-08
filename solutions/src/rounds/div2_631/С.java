package rounds.div2_631;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class С {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[m];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        if (sum < n) {
            System.out.println("-1");
            return;
        }
        long initialSum[] = new long[n];
        initialSum[0] = sum;
        for (int i = 1; i < m; i++) {
            initialSum[i] = initialSum[i - 1] - a[i];
        }

        long res[] = new long[n];
        for (int i = 0; i < n; i++) {
            if (initialSum[i] <= n - i) {
                int index = n - 1;
                for (int j = m - 1; j >= i; j--) {
                    for (int k = 0; k < a[j]; k++) {
                        res[index--] = j + 1;
                    }
                }
                break;
            }
            res[i] = i + 1;
        }
        for (int i = 1; i < n; i++) {
            if (res[i] == 0) res[i] = res[i - 1];
        }
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(res[i]);
        }
        if (set.size()<m) {
            System.out.println("-1");
            return;
        }
        System.out.print(1 + " ");
        for (int i = 1; i < n; i++) {
            if (res[i] != res[i - 1]) System.out.print((i + 1) + " ");
        }
    }
}
