import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        ArrayList<int[]> diceArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] dice = {5, 1, 2, 6};
            diceArr.add(dice);
        }
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            int a = Integer.valueOf(line[0]);
            int b = Integer.valueOf(line[1]);
            
            if (a > 0 && b > 0) diceArr = change(diceArr, a, b);
            else if (b == -1) diceArr.set((a - 1), forward(diceArr.get(a - 1)));
            else if (b == -2) diceArr.set(a - 1, right(diceArr.get(a - 1)));

            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(diceArr.get(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(diceArr.get(i)[1] + (i == n - 1 ? "" : " "));
        }
        scanner.close();
    }

    public static ArrayList<int[]> change(ArrayList<int[]> arr, int a, int b) {
        int[] aDice = arr.get(a - 1);
        int[] bDice = arr.get(b - 1);

        arr.set(a - 1, bDice);
        arr.set(b - 1, aDice);
        return arr;
    }

    public static int[] forward(int[] dice) {
        int loc = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 3 || dice[i] == 1 || dice[i] == 4) loc = i;
        }
        int on = dice[loc];
        
        if (on == 1 || on == 5 || on == 2) {
            dice[1] = 3;
        } else if (on == 3) {
            dice[1] = 6;
        } else if (on == 6) {
            dice[1] = 4;
        } else if (on == 4) {
            dice[1] = 1;
        }
        return dice;
    }

    public static int[] right(int[] dice) {
        int[] newArr = new int[4];
        for (int i = 1; i < 4; i++) {
            newArr[i] = dice[i - 1];
        }
        newArr[0] = dice[3];
        return newArr;
    }
}