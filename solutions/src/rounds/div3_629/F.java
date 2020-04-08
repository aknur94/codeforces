package rounds.div3_629;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();
        switch (text) {
            case "DOCTOR":
            case "MARY":
            case "SMARTPHONE":
            case "HOLMES":
                System.out.println("NO");
                break;
            default:
                System.out.println("YES");
                break;
        }
    }
}
