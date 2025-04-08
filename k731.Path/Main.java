import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = 0;
        int rotate = 0;
        int cacheX = 0;
        int cacheY = 0;
        int status = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int newStatus = 0;
            if (cacheX == x) newStatus = y > cacheY ? 1 : 2;
            else if (cacheY == y) newStatus = x > cacheX ? 4 : 3;
            if (i == 0) {
                cacheX = x;
                cacheY = y;
                status = newStatus;
                continue;
            }

            if ((status == 2 && newStatus == 1) || (status == 1 && newStatus == 2) ||
                (status == 3 && newStatus == 4) || (status == 4 && newStatus == 3)) {
                    rotate += 1;
            } else if ((status == 1 && newStatus == 4) || (status == 4 && newStatus == 2) ||
                (status == 2 && newStatus == 3) || (status == 3 && newStatus == 1)) {
                    right += 1;
            } else if ((status == 4 && newStatus == 1) || (status == 2 && newStatus == 4) ||
                (status == 3 && newStatus == 2) || (status == 1 && newStatus == 3)) {
                    left += 1;
            }

            cacheX = x;
            cacheY = y;
            status = newStatus;
        }

        System.out.println(left + " " + right + " " + rotate);
        scanner.close();
    }
}