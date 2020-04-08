package rounds.div3_629;

import java.util.Scanner;

public class A629 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int div = a/b;
            int result = (div+1)*b - a;
            System.out.println(result%b);
        }
    }
}
