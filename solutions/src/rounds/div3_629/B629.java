package rounds.div3_629;

import java.util.Scanner;

public class B629 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            k++;
            int d = 1;
            int step = 1;
            while(d<k) {
                d+=step;
                ++step;
            }
            d = 0;

            System.out.println(step);
        }
    }
}
