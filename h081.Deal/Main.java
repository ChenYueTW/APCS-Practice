import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int D = Integer.parseInt(firstLine[1]);

        int[] price = new int[n];
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(line[i]);
        }

        int stockPrice = price[0];
        int lastDealPrice = 0;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (price[i] >= stockPrice + D && stockPrice != 0) {
                ans += price[i] - stockPrice;
                lastDealPrice = price[i];
                stockPrice = 0;
            } else if (stockPrice == 0 && price[i] <= lastDealPrice - D) {
                stockPrice = price[i];
                lastDealPrice = 0;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}