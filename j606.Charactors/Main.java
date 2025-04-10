import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int k = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);
        int r = Integer.parseInt(firstLine[2]);
        String[] str = scanner.nextLine().split("");
        ArrayList<String[]> arr = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] cache = str.clone();
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < k; j++) {
                str[Integer.parseInt(line[j]) - 1] = cache[j];
            }
            arr.add(str.clone());
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(arr.get(j)[i]);
            }
            System.out.println();
        }
        scanner.close();
    }
}