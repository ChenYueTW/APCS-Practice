import java.util.Scanner;

public class Rebuild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);
        int[][] flow = new int[n][m];
        int[][] serverLoc = new int[k][n];

        // Init FLOW
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                flow[i][j] = Integer.valueOf(line[j]);
            }   
        }
        // Init PLAN
        for (int i = 0; i < k; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                serverLoc[i][j] = Integer.valueOf(line[j]);
            }
        }


    }
}
