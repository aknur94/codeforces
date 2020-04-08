package train.spbgu;

import java.util.Scanner;

public class Dyn_I_Knapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i <n; i++) {
            a[i] = in.nextInt();
        }
        boolean bool[] = new boolean[s+1];
        bool[0] = true;
        for (int i = 0; i < n ; i++) {
            for (int j = s; j > 0; j--) {
                if (j - a[i] < 0) break;
                if (bool[j-a[i]]) bool[j] = true;
            }
        }
        for (int i = s; i >= 0 ; i--) {
            if (bool[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
