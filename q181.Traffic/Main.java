import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String traffic = scanner.nextLine();
        int a = Integer.valueOf(traffic.split(" ")[0]);
        int b = Integer.valueOf(traffic.split(" ")[1]);
        int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        String[] time = scanner.nextLine().split(" ");
        int redSeconds = 0;
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.valueOf(time[i]);
        }

        for (int i = 0; i < n; i++) {
            int t = times[i] % (a + b);
            if (t > a) {
                redSeconds += b - (t - a);
            } else if (t < a) {
                redSeconds += 0;
            } else if (t == a) {
                redSeconds += b;
            }
        }

        System.out.println(redSeconds);
        scanner.close();
    }
}