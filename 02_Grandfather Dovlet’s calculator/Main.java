import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt(), last = sc.nextInt();

        int[] pattern = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        ArrayList<Integer> digits = new ArrayList<>((int)(Math.log10(last)+1));
        int lastSum = 0;
        int sum = 0;


        for (int i = first; i <= last; i++) {
            int current = i;
            int numbers = (int)(Math.log10(i)+1);

            for (int j = 1; j <= numbers; j++) {
                int digit = (current % (int) Math.pow(10, j)) / (int) Math.pow(10, j - 1);

                if (i > first && digits.size() == numbers) {
                    if (digits.get(numbers - j) != digit) {
                        lastSum -= pattern[digits.get(numbers - j)];
                        lastSum += pattern[digit];
                        digits.set(numbers - j, digit);
                    }
                    else break;
                }
                else if (i == first) {
                    digits.add(0, digit);
                    lastSum += pattern[digit];
                }
                else if (digits.size() != 0 && digits.size() < numbers) {
                    if (numbers - j < digits.size()) {
                        lastSum -= pattern[digits.get(numbers - j)];
                        digits.set(numbers - j, digit);
                    }
                    else digits.add(digit);
                    lastSum += pattern[digit];
                }
                current -= digit * Math.pow(10, j - 1);
            }
            sum += lastSum;
        }

        System.out.print(sum);
    }
}
