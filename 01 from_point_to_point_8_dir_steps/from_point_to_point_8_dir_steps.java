import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] start = {sc.nextInt(), sc.nextInt()};
        int[] end = {sc.nextInt(), sc.nextInt()};

        int one = Math.abs(end[0] - start[0]) <= Math.abs(end[1] - start[1]) ? 0 : 1;
        int two = one == 0 ? 1 : 0;

        int moves_1 = end[one] - start[one];
        int moves_2 = end[two] - start[two];

        int m = moves_1 > 0 && moves_2 <= 0 || moves_1 < 0 && moves_2 >= 0 ? -1 : 1;

        int[] result = {start[one] + moves_1, start[two] + moves_1 * m};
        if(one != 0) {
            int t = result[0];
            result[0] = result[1];
            result[1] = t;
        }

        System.out.print(Math.abs(moves_1) + Math.abs(end[two] - result[two]));
    }
}
