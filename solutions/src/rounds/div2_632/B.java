package rounds.div2_632;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
            }
            if (a[0] != b[0]) {
                System.out.println("NO");
                continue;
            }
            boolean can = true;
            boolean has1 = a[0] > 0;
            boolean has_1 = a[0] < 0;
            for (int j = 1; j < n; j++) {
                int diff = b[j] - a[j];
                if (diff < 0 && !has_1) {
                    System.out.println("NO");
                    can = false;
                    break;
                }
                if (diff > 0 && !has1) {
                    System.out.println("NO");
                    can = false;
                    break;
                }
                has1 = has1 || a[j] > 0;
                has_1 = has_1 || a[j] < 0;
            }
            if (can) {
                System.out.println("YES");
            }
        }
    }
}
