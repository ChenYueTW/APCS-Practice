import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};

        int[] moveArr = new int[]{0, 0, 0, 0};
        if (m == 0) moveArr = new int[]{2, 0, 3, 1};
        else if (m == 1) moveArr = new int[]{0, 3, 1, 2};
        else if (m == 2) moveArr = new int[]{3, 1, 2, 0};
        else if (m == 3) moveArr = new int[]{1, 2, 0, 3};

        int nx = n / 2, ny = n / 2;
        int cache = 1;
        boolean isFinished = false;
        System.out.print(arr[ny][nx]);
        while ((nx >= 0 && nx < n && ny >= 0 && ny < n) || cache == n) {
            int movement = 0;

            for (int i = 0; i < cache; i++) {
                ny += dy[moveArr[movement]];
                nx += dx[moveArr[movement]];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) System.out.print(arr[ny][nx]);
                else {
                    isFinished = true;
                    break;
                }
            }
            if (isFinished) break;
            movement++;
            for (int i = 0; i < cache; i++) {
                ny += dy[moveArr[movement]];
                nx += dx[moveArr[movement]];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) System.out.print(arr[ny][nx]);
                else {
                    isFinished = true;
                    break;
                }
            }
            if (isFinished) break;
           
            cache++;
            movement++;
            for (int i = 0; i < cache; i++) {
                ny += dy[moveArr[movement]];
                nx += dx[moveArr[movement]];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) System.out.print(arr[ny][nx]);
                else {
                    isFinished = true;
                    break;
                }
            }
            if (isFinished) break;
            movement++;
            for (int i = 0; i < cache; i++) {
                ny += dy[moveArr[movement]];
                nx += dx[moveArr[movement]];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) System.out.print(arr[ny][nx]);
                else {
                    isFinished = true;
                    break;
                }
            }
            if (isFinished) break;
            cache++;
        }
    }
}