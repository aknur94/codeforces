package train.menshikov.train1;

import java.util.Scanner;

public class A_Prime_Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean isAbsent = true;
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                isAbsent = false;
                System.out.println(i);
            }
        }
        if (isAbsent) System.out.println("Absent");
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i%j ==0)
                return false;
        }
        return true;
    }
}
