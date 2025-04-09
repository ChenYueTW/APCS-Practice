import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        BigInteger[] s = new BigInteger[n];
        BigInteger[] t = new BigInteger[n];
        ArrayList<Integer> idx = new ArrayList<>();
        int[] condition = new int[n];

        String[] sLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = new BigInteger(sLine[i]);
        }
        String[] tLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            t[i] = new BigInteger(tLine[i]);
        }
        String[] idxLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            idx.add(Integer.parseInt(idxLine[i]));
        }

        while (idx.size() != 1) {
            ArrayList<Integer> nextRound = new ArrayList<>();
            int cache = idx.size() % 2;
            if (cache != 0) {
                int last = idx.remove(idx.size() - 1);
                nextRound.add(last);
            }
            ArrayList<Integer> winPlayer = new ArrayList<>();
            ArrayList<Integer> losePlayer = new ArrayList<>();

            for (int i = 0; i < idx.size() / 2; i++) { // Round start
                int firstPlayer = idx.get(i * 2);
                int secondPlayer = idx.get(i * 2 + 1);

                BigInteger a = s[firstPlayer - 1];
                BigInteger b = t[firstPlayer - 1];
                BigInteger c = s[secondPlayer - 1];
                BigInteger d = t[secondPlayer - 1];

                if (a.multiply(b).compareTo(c.multiply(d)) >= 0) { // FirstPlayer win
                    s[firstPlayer - 1] = a.add(c.multiply(d).divide(BigInteger.valueOf(2).multiply(b)));
                    t[firstPlayer - 1] = b.add(c.multiply(d).divide(BigInteger.valueOf(2).multiply(a)));
                    s[secondPlayer - 1] = c.add(c.divide(BigInteger.valueOf(2)));
                    t[secondPlayer - 1] = d.add(d.divide(BigInteger.valueOf(2)));
                    winPlayer.add(firstPlayer);
                    losePlayer.add(secondPlayer);
                } else { // SecondPlayer win
                    s[secondPlayer - 1] = c.add(a.multiply(b).divide(BigInteger.valueOf(2).multiply(d)));
                    t[secondPlayer - 1] = d.add(a.multiply(b).divide(BigInteger.valueOf(2).multiply(c)));
                    s[firstPlayer - 1] = a.add(a.divide(BigInteger.valueOf(2)));
                    t[firstPlayer - 1] = b.add(b.divide(BigInteger.valueOf(2)));
                    winPlayer.add(secondPlayer);
                    losePlayer.add(firstPlayer);
                }
            } // Round end

            // Add lose to condition
            for (int player : losePlayer) {
                condition[player - 1] += 1;
            }

            // Detect lose arrive m
            for (int i = 0; i < idx.size(); i++) {
                int player = idx.get(i) - 1;
                if (condition[player] == m) {
                    losePlayer.remove(getIndex(losePlayer, player + 1));
                }
            }

            // Plan nextround idx
            for (int player : winPlayer) {
                nextRound.add(player);
            }
            if (cache != 0) {
                int seed = nextRound.remove(0);
                nextRound.add(seed);
            }
            for (int player : losePlayer) {
                nextRound.add(player);
            }

            // idx reload
            idx.clear();
            idx = nextRound;
        }

        System.out.println(idx.get(0));
        scanner.close();
    }

    public static int getIndex(ArrayList<Integer> arr, int player) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == player) return i;
        }
        return 0;
    }
}
