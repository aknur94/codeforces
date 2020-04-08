package train.menshikov.train6;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char a[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next().toCharArray();
        }
        char from[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                from[i][j] = '.';
            }
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean broken = false;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    list.add(new Pair<>(i,j));
                    from[i][j] = 'X';
                    broken = true;
                    break;
                }
            }
            if (broken) break;
        }
        int index = 0;
        boolean hasAnswer = false;
        while(index < list.size()) {
            int i = list.get(index).getKey();
            int j = list.get(index).getValue();
            if (a[i][j] == '@') {
                show(from, a, i, j);
                hasAnswer = true;
                break;
            }
            if (i-1>=0 && a[i-1][j] != 'O' && from[i-1][j] == '.') {
                list.add(new Pair<>(i-1, j));
                from[i-1][j] = 'u';
            }
            if (i+1<n && a[i+1][j] != 'O' && from[i+1][j] == '.') {
                list.add(new Pair<>(i+1, j));
                from[i+1][j] = 'd';
            }
            if (j+1<n && a[i][j+1] != 'O' && from[i][j+1] == '.') {
                list.add(new Pair<>(i, j+1));
                from[i][j+1] = 'r';
            }
            if (j-1>=0 && a[i][j-1] != 'O' && from[i][j-1] == '.') {
                list.add(new Pair<>(i, j-1));
                from[i][j-1] = 'l';
            }
            index++;
        }
        if (!hasAnswer) System.out.println("N");
    }

    private static void show(char[][] from, char[][] a, int i, int j) {
        while(true) {
            if (from[i][j] == 'u'){
                ++i;

            } else if (from[i][j] == 'd'){
                --i;

            } else if (from[i][j] == 'r'){
                --j;

            } else if (from[i][j] == 'l'){
                ++j;

            }
            if (a[i][j] == 'X') {
                a[i][j] = '+';
                break;
            }
            a[i][j] = '+';
        }
        System.out.println("Y");
        for (int k = 0; k < a[0].length; k++) {
            for (int l = 0; l < a[0].length; l++) {
                System.out.print(a[k][l]);
            }
            System.out.println();
        }
    }
}
