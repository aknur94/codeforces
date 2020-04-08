package train.menshikov.train1;

import java.util.Scanner;

public class B_Minus_Plus {

    static int n;
    static int s;
    static int[] x = new int[24];
    static char[] ch = new char[24];
    static boolean hasSolution = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         n = in.nextInt();
         s = in.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        solve(2, '-', x[0]-x[1]);
        solve(2, '+', x[0]+x[1]);

        if (!hasSolution) System.out.println("No solution");
    }

    private static void solve(int i, char c, int sum) {
        if (hasSolution) return;
        ch[i-2] = c;
        if (i == n && sum == s) {
            show();
            return;
        } else if (i == n) return;
        solve(i+1, '-', sum-x[i]);
        solve(i+1, '+', sum+x[i]);
    }

    private static void show() {
        System.out.print(x[0]);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(ch[i]);
            System.out.print(x[i+1]);
        }
        System.out.print("=" + s);
        hasSolution = true;
    }


}
