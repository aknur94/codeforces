package train.spbgu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dyn_F_Yadro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int sum2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            sum+=i;
            sum2+=sum;
            list.add(sum2);
            if (sum2>300000) break;
        }
        for (Integer m :
                list) {
            System.out.print(m+" ");
        }
    }
}
