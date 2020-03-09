package archive;

import java.util.Scanner;

/*
 * http://codeforces.com/problemset/problem/705/A
 */
public class A366div2_Hulk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (i%2==0)
                System.out.print("I hate ");
            else
                System.out.print("I love ");
            if (i<n-1)
            System.out.print("that ");
        }
        System.out.print("it");
    }
}
