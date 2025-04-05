import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[2 * n][7];
        String[] ans = new String[n];

        for (int i = 0; i < 2 * n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.valueOf(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            boolean a = (
                (arr[i * 2][1] != arr[i * 2][3]) && (arr[i * 2][1] == arr[i * 2][5]) &&
                (arr[i * 2 + 1][1] != arr[i * 2 + 1][3]) && (arr[i * 2 + 1][1] == arr[i * 2 + 1][5]));
            boolean b = (arr[i * 2][6] == 1 && arr[i * 2 + 1][6] == 0);
            boolean c = (
                (arr[i * 2][1] != arr[i * 2 + 1][1]) &&
                (arr[i * 2][3] != arr[i * 2 + 1][3]) &&
                (arr[i * 2][5] != arr[i * 2 + 1][5]));
            
            String str = "";
            if (a && b && c) str = "None";
            else str = (a ? "" : "A") + (b ? "" : "B") + (c ? "" : "C");
            ans[i] = str;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
        scanner.close();
    }
}