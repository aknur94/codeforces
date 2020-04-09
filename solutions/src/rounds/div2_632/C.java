package rounds.div2_632;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
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
                    falseIndex = j;
                    break;
                }
            }
            for (int j = i; j >=0 && isGood[j] ; j--) {
                res++;
            }
        }
        System.out.println(res);
    }
}
