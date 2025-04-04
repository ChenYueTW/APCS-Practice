import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        ArrayList<int[][]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[][] intArr = {{0, 3, 0, 0}, {5, 1, 2, 6}, {0, 4, 0, 0}};
            arr.add(intArr);
        }

        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            int a = Integer.valueOf(line[0]);
            int b = Integer.valueOf(line[1]);

            if (a > 0 && b > 0) { // Change
                int[][] aDice = getDiceVal(arr.get(a - 1));
                int[][] bDice = getDiceVal(arr.get(b - 1));

                arr.set(a - 1, bDice);
                arr.set(b - 1, aDice);
            } else if (b == -1) { // Forward
                int[][] dice = getDiceVal(arr.get(a - 1));

                // Rotate
                int cache = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = dice[1][3];
                dice[1][3] = cache;

                arr.set(a - 1, dice);
            } else if (b == -2) { // Right
                int[][] dice = getDiceVal(arr.get(a - 1));

                int cache = dice[1][3];
                dice[1][3] = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = cache;
                
                arr.set(a - 1, dice);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i)[1][1] + (i == n - 1 ? "" : " "));
        }

        scanner.close();
    }

    public static int[][] getDiceVal(int[][] dice) {
        int[][] copy = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = dice[i][j];
            }
        }
        return copy;
    }
}
