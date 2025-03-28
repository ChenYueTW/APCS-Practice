import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] n = scanner.nextLine().split("");
        int a = 0;
        int b = 0;

        for (int i = 0; i < n.length / 2 + (n.length % 2 == 0 ? 0 : 1); i++) {
            a += Integer.valueOf(n[i * 2]);
        }
        for (int i = 0; i < n.length / 2; i++) {
            b += Integer.valueOf(n[i * 2 + 1]);
        }

        System.out.println(Math.abs(a - b));
        scanner.close();
    }
}