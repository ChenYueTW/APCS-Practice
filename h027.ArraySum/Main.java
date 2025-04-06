import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int s = Integer.parseInt(firstLine[0]);
        int t = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        int m = Integer.parseInt(firstLine[3]);
        int r = Integer.parseInt(firstLine[4]);

        int[][] aArray = new int[s][t];
        int[][] bArray = new int[n][m];
        int aSum = 0;
        int ans = 0;
        int minVal = Integer.MAX_VALUE;

        // Init array
        for (int i = 0; i < s; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < t; j++) {
                aArray[i][j] = Integer.parseInt(line[j]);
                aSum += aArray[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                bArray[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i <= n - s; i++) {
            for (int j = 0; j <= m - t; j++) {
                int[] arr = getDistance(aArray, t, s, bArray, new int[]{j, i});
                int distance = arr[0];
                int bSum = arr[1];
                if (distance <= r) {
                    ans += 1;
                    minVal = minVal > Math.abs(aSum - bSum) ? Math.abs(aSum - bSum) : minVal; 
                }
            }
        }

        System.out.println(ans);
        System.out.println(ans == 0 ? -1 : minVal);
        scanner.close();
    }

    public static int[] getDistance(int[][] aArray, int aX, int aY, int[][] bArray, int[] startPoint) {
        int x = startPoint[0];
        int y = startPoint[1];
        int cache = 0;
        int subSum = 0;

        for (int i = 0; i < aY; i++) {
            for (int j = 0; j < aX; j++) {
                if (aArray[i][j] != bArray[y + i][x + j]) cache += 1;
                subSum += bArray[y + i][x + j];
            }
        }

        return new int[]{cache, subSum};
    }
}