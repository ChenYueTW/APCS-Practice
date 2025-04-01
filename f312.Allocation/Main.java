import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int a1 = Integer.valueOf(firstLine[0]);
        int b1 = Integer.valueOf(firstLine[1]);
        int c1 = Integer.valueOf(firstLine[2]);
        
        String[] secondLine = scanner.nextLine().split(" ");
        int a2 = Integer.valueOf(secondLine[0]);
        int b2 = Integer.valueOf(secondLine[1]);
        int c2 = Integer.valueOf(secondLine[2]);
        
        int n = Integer.valueOf(scanner.nextLine());
        
        int ans = -Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            int x1 = i;
            int x2 = n - i;
            int y1 = a1 * x1 * x1 + b1 * x1 + c1;
            int y2 = a2 * x2 * x2 + b2 * x2 + c2;
            ans = ans > y1 + y2 ? ans : y1 + y2;
        }
        System.out.println(ans);
        scanner.close();
    }
}