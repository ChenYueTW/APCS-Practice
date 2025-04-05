import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] fence = new int[n];
        String[] line = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            fence[i] = Integer.parseInt(line[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (fence[i] == 0) { // fence broke
                if (i == 0) { // left side
                    ans += fence[1];
                } else if (i == n - 1) { // right side
                    ans += fence[n - 2];
                } else {
                    ans += fence[i + 1] > fence[i - 1] ? fence[i - 1] : fence[i + 1];
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}