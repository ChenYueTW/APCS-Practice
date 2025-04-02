import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int d = Integer.valueOf(firstLine[1]);
        ArrayList<Integer> average = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int[] price = new int[3];
            for (int j = 0; j < 3; j++) {
                price[j] = Integer.valueOf(line[j]);
            }
            Arrays.sort(price);
            if (d <= price[2] - price[0])  average.add((price[0] + price[1] + price[2]) / 3);
        }

        int ans = 0;
        for (int i = 0; i < average.size(); i++) {
            ans += average.get(i);
        }
        System.out.println(average.size() + " " + ans);
        scanner.close();
    }
}