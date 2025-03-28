import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.valueOf(firstLine[0]);
        int n = Integer.valueOf(firstLine[1]);
        int[] color = new int[n];
        String[] colorLine = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            color[i] = Integer.valueOf(colorLine[i]);
        }

        for (int i = 0; i < color.length / 3; i++) {
            
        }
    }
}