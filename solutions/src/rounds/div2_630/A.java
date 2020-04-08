package rounds.div2_630;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long d = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long x1 = in.nextLong();
            long y1 = in.nextLong();
            long x2 = in.nextLong();
            long y2 = in.nextLong();

            long horizontal = b - a;
            long vertical = d - c;

            if (((x == x1 && x == x2) && (a > 0 || b > 0)) || ((y1 == y && y2 == y) && (c > 0 || d > 0) )) {
                System.out.println("NO");
                continue;
            }

            x += horizontal;
            y += vertical;

            if(x < x1 || x > x2 || y < y1 || y > y2) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
