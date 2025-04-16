import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int r = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        int [][] arr = new int[r][c];
        ArrayList<int[][]> data = new ArrayList<>();
        int ans = 0;

        data.add(new int[][]{{0, 0, 0, 0}, {0, 1, 2, 3}}); // A
        data.add(new int[][]{{0, -1, -2}, {0, 0, 0}}); // B
        data.add(new int[][]{{0, -1, 0, -1}, {0, 0, 1, 1}}); // C
        data.add(new int[][]{{0, -2, -1, 0}, {0, 1, 1, 1}}); // D
        data.add(new int[][]{{0, -1, 0, -1, 0}, {0, 1, 1, 2, 2}}); // E

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            int type = -1;
            if (line[0].equals("A")) type = 0;
            else if (line[0].equals("B")) type = 1;
            else if (line[0].equals("C")) type = 2;
            else if (line[0].equals("D")) type = 3;
            else if (line[0].equals("E")) type = 4;
            int dis = Integer.parseInt(line[1]);

            boolean isPut = true;
            int pos = c - 1;
            while (pos >= 0) {
                boolean canPut = true;
                for (int k = 0; k < data.get(type)[0].length; k++) {
                    int nx = pos + data.get(type)[0][k];
                    int ny = dis + data.get(type)[1][k];
                    if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                        if (arr[ny][nx] == 1) {
                            canPut = false;
                            break;
                        }
                    } else {
                        canPut = false;
                        break;
                    }
                }
                if (!canPut) break;
                pos--;
            }
            pos += 1; // Last Loc
            for (int k = 0; k < data.get(type)[0].length; k++) {
                if (pos >= c) {
                    isPut = false;
                    break;
                }
                int nx = pos + data.get(type)[0][k];
                int ny = dis + data.get(type)[1][k];
                arr[ny][nx] = 1;
            }
            if (!isPut) ans += 1;
        }
        int space = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) space += 1;
            }
        }
        System.out.println(space + " " + ans);
    }
}