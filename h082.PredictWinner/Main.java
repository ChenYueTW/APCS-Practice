import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        ArrayList<int[]> arr = new ArrayList<>();
        int[] s = new int[n];
        int[] t = new int[n];
        int[] idx = new int[n];

        for (int i = 0; i < 2; i++) {
            int[] cache = new int[n];
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr.set(i, cache);
                
            }
        }

        String[] sLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(sLine[i]);
        }
        String[] tLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(tLine[i]);
        }
        String[] idxLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            idx[i] = Integer.parseInt(idxLine[i]);
        }


    }
}