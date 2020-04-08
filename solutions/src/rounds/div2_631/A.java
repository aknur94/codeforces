package rounds.div2_631;


import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int x = in.nextInt();
            int b[] = new int[101];
            for (int j = 0; j < n; j++) {
                int q = in.nextInt();
                b[q]++;
            }
            int res = 0;
            for (int j = 1; j < 101; j++) {
                if (b[j]>0) {
                    res++;
                    continue;
                }
                if (x>0) {
                    --x;
                    res++;
                    continue;
                }
                break;
            }
            System.out.println(res+x);
        }
    }
}
