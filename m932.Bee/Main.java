import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);
        String[][] map = new String[m][n];
        HashSet<String> set = new HashSet<>();
        String ans = "";

        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = line[j];
            }
        }

        String[] active = scanner.nextLine().split(" ");
        int[] dx = {0, 1, 1, 0, -1, -1};
        int[] dy = {-1, 0, 1, 1, 0, -1};
        int x = 0;
        int y = m - 1;

        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(active[i]);
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                ans += map[ny][nx];
                x = nx;
                y = ny;
            } else {
                ans += map[y][x];
            }   
        }
        
        String[] ansLine = ans.split("");
        for (int i = 0; i < ans.length(); i++) {
            set.add(ansLine[i]);
        }

        System.out.println(ans);
        System.out.println(set.size());
        scanner.close();
    }
}