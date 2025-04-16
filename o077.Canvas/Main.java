import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int h = Integer.parseInt(firstLine[0]);
        int w = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        int[][] map = new int[h][w];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int y = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int t = Integer.parseInt(line[2]);
            int val = Integer.parseInt(line[3]);

            int length = t * 2 - 1;
            for (int nx = x + 1; nx <= x + t; nx++) {
                for (int ny = y - ((length - 1) / 2); ny <= y - ((length - 1) / 2) + length - 1; ny++) {
                    if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                        map[ny][nx] += val;
                    }
                }
                length -= 2;
            }
            length = t * 2 - 1;
            for (int nx = x - 1; nx >= x - t; nx--) {
                for (int ny = y - ((length - 1) / 2); ny <= y - ((length - 1) / 2) + length - 1; ny++) {
                    if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                        map[ny][nx] += val;
                    }
                }
                length -= 2;
            }
            for (int ny = y - t; ny <= y + t; ny++) {
                if (x >= 0 && x < w && ny >= 0 && ny < h) {
                    map[ny][x] += val;
                }
            }
        }

        for (int ky = 0; ky < h; ky++) {
            for (int kx = 0; kx < w; kx++) {
                System.out.print(map[ky][kx] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
