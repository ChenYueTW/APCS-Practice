import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        int[] max = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int cache = 0;
            for (int j = 0; j < m; j++) {
                int value = Integer.valueOf(line[j]);
                cache = value > cache ? value : cache;
            }
            max[i] = cache;
            s += cache;
        }

        System.out.println(s);
        int z = 0;
        for (int i = 0; i < max.length; i++) {
            if (s % max[i] == 0)  {
                System.out.print((z == 0 ? "" : " ") + max[i]);
                z += 1;
            }
        }
        if (z == 0) System.out.println(-1);
        scanner.close();
    }
}