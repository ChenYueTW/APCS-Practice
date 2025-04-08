import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        String[] line = scanner.nextLine().split(" ");
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(line[i]);
            set.add(arr[i]);
        }
        Arrays.sort(arr);

        int p = 1;
        for (int i = 0; i < 2; i++) {
            if (arr[i] == arr[i + 1]) p += 1;
        }
        
        ArrayList<Integer> ansArr = new ArrayList<>();
        for (int i : set) {
            ansArr.add(i);
        }
        Arrays.sort(ansArr.toArray());

        System.out.print(p);
        for (int i = ansArr.size() - 1; i >= 0; i--) {
            System.out.print(" " + ansArr.get(i));
        }
        scanner.close();
    }
}