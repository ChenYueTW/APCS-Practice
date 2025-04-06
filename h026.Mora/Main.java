import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int F = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        int[] y = new int[N];
        ArrayList<Integer> bro = new ArrayList<>();
        boolean isTie = true;

        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < N; i++) {
            if (i > 1) {
                int last = y[i - 1];
                int doubleLast = y[i - 2];

                if (last == doubleLast) {
                    int mora = 0;
                    if (last == 0) mora = 5;
                    else if (last == 2) mora = 0;
                    else mora = 2;
                    bro.add(mora);
                } else {
                    bro.add(y[i - 1]);
                }
            } else if (i == 0) {
                bro.add(F);
            } else {
                bro.add(y[i - 1]);
            }
            int condition = mora(bro.get(i), y[i]);

            if (condition == 0 || condition == 1) {
                for (int j = 0; j < bro.size(); j++) {
                    System.out.print(bro.get(j) + " ");
                }
                isTie = false;
                System.out.print(": " + (condition == 0 ? "Won" : "Lost") + " at round " + (i + 1));
                break; 
            }
        }

        if (isTie) {
            for (int j = 0; j < bro.size(); j++) {
                System.out.print(bro.get(j) + " ");
            }
            System.out.println(": Drew at round " + N);
        }
        scanner.close();
    }

    // Win = 0
    // Lose = 1
    // Tie = 2
    public static int mora(int bro, int sis) {
        if (bro == 0) {
            if (sis == 0) return 2;
            else if (sis == 2) return 0;
            else return 1;
        } else if (bro == 2) {
            if (sis == 0) return 1;
            else if (sis == 2) return 2;
            else return 0;
        } else {
            if (sis == 0) return 0;
            else if (sis == 2) return 1;
            else return 2;
        }
    }
}