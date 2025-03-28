import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String[] buildings = scanner.nextLine().split(" ");
        int[] heights = new int[n];
        int length = 1;
        int cache = 0;

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.valueOf(buildings[i]);
        }

        for (int i = 1; i < heights.length; i++) {
            if (heights[i - 1] > heights[i]) {
                length += 1;
                cache = cache < length ? length : cache;
            } else {
                length = 1;
            }
        }

        System.out.println(cache);
        scanner.close();
    }
}
