import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        String s[] = scanner.nextLine().split("");
        int length = 0;

        for (int i = 0; i < s.length; i++) {
            String[] range = new String[k * 2];
        }

        System.out.println(length);
        scanner.close();
    }
}