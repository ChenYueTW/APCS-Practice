import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int x = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int left = 0;
        int right = 0;

        String[] food = scanner.nextLine().split(" ");
        int[] arr =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(food[i]);
            if (arr[i] > x) right += 1;
            else left += 1;
        }
        Arrays.sort(arr);

        System.out.println((left > right ? left : right) + " " + (left > right ? arr[0] : arr[n - 1]));
        scanner.close();
    }
}