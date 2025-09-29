import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers separated by spaces:");
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : parts) {
            Integer num = Integer.parseInt(s);
            numbers.add(num);
        }
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        System.out.println("Sum of integers = " + sum);
        sc.close();
    }
}
