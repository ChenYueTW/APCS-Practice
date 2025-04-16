import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[][] arr = new int[n][m];
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = arr[i][j];
                int total = 0;
                for (int kx = -9; kx <= 9; kx++) {
                    for (int ky = -9; ky <= 9; ky++) {
                        int nx = kx + j;
                        int ny = ky + i;
                        if (Math.abs(nx - j) + Math.abs(ny - i) <= x) {
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                total += arr[ny][nx];
                            }
                        }
                    }
                }
                if (total % 10 == x) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        System.out.println(ans.size());
        for (int[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
        scanner.close();
    }
}