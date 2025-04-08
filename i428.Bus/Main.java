import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int cacheX = 0;
        int cacheY = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            if (i == 0) {
                cacheX = Integer.parseInt(line[0]);
                cacheY = Integer.parseInt(line[1]);
                continue;
            }
            int distance = Math.abs(cacheX - Integer.parseInt(line[0])) + Math.abs(cacheY - Integer.parseInt(line[1]));
            maxVal = maxVal < distance ? distance : maxVal;
            minVal = minVal < distance ? minVal : distance;
            cacheX = Integer.parseInt(line[0]);
            cacheY = Integer.parseInt(line[1]);
        }
        System.out.println(maxVal + " " + minVal);
        scanner.close();
    }
}