import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][2];
        int maxSkullVal = Integer.MIN_VALUE;
        int secondVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
            int skullVal = (int) Math.pow(arr[i][0], 2) + (int) Math.pow(arr[i][1], 2);
            maxSkullVal = maxSkullVal > skullVal ? maxSkullVal : skullVal;
        }
        for (int i = 0; i < n; i++) {
            int skullVal = (int) Math.pow(arr[i][0], 2) + (int) Math.pow(arr[i][1], 2);
            if (skullVal < maxSkullVal) {
                secondVal = secondVal > skullVal ? secondVal : skullVal;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int skullVal = (int) Math.pow(arr[i][0], 2) + (int) Math.pow(arr[i][1], 2);
            if (skullVal == secondVal) {
                a = arr[i][0];
                b = arr[i][1];
                break;
            }
        }
        System.out.println(a + " " + b);
        scanner.close();
    }
}