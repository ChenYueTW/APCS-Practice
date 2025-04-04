import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);

        int[][] q = new int[n][m];
        int[][] c = new int[k][n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                q[i][j] = Integer.valueOf(line[j]);
            }
        }

        for (int i = 0; i < k; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                c[i][j] = Integer.valueOf(line[j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                // c[i][j] City
                // j Numer j server
                int f = q[j][c[i][j]];
            }
        }
    }
}