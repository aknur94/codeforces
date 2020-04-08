package rounds.div2_630;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int k = 0;
            int b[] = new int[n];
            for (int j = 0; j < 11; j++) {
                boolean color = false;
                for (int l = 0; l < n; l++) {
                    if (a[l] % primes[j] == 0 && b[l] == 0) {
                        if (!color) {
                            color = true;
                            k++;
                        }
                        b[l] = k;
                    }
                }
            }
            System.out.println(k);
            for (int j = 0; j < n; j++) {
                System.out.print(b[j] + " ");
            }
            System.out.println();
        }
    }
}
