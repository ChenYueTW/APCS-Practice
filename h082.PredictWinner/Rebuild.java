import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rebuild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();
        ArrayList<Integer> condition = new ArrayList<>();

        String[] sLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(sLine[i]));
        }
        String[] tLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            t.add(Integer.parseInt(tLine[i]));
        }
        String[] idxLine = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            idx.add(Integer.parseInt(idxLine[i]));
        }
        for (int i = 0; i < n; i++) {
            condition.add(0);
        }

        while (idx.size() != 1) {
            ArrayList<Integer> winner = new ArrayList<>();
            ArrayList<Integer> losser = new ArrayList<>();
            boolean hasLast = false;
            int lastNum = 0;
            
            if (idx.size() % 2 != 0) {
                lastNum = idx.get(idx.size() - 1);
                hasLast = true;
                idx.remove(idx.size() - 1);
            }
            System.out.println(idx.toString());
            for (int i = 0; i < idx.size() / 2; i++) {
                int a = s.get(idx.get(i * 2) - 1);
                int b = t.get(idx.get(i * 2) - 1);
                int c = s.get(idx.get(i * 2 + 1) - 1);
                int d = t.get(idx.get(i * 2 + 1) - 1);

                int firstNum = idx.get(i * 2) - 1;
                int secondNum = idx.get(i * 2 + 1) - 1;
                if (a * b >= c * d) {
                    // Win
                    s.set(firstNum, a + (c * d) / (2 * b));
                    t.set(firstNum, b + (c * d) / (2 * a));
                    winner.add(firstNum);
                    // Lose
                    s.set(secondNum, c + c / 2);
                    t.set(secondNum, d + d / 2);
                    losser.add(secondNum);
                } else {
                    // Win
                    s.set(secondNum, c + (a * b) / (2 * d));
                    t.set(secondNum, d + (a * b) / (2 * c));
                    winner.add(secondNum);
                    // Lose
                    s.set(firstNum, a + a / 2);
                    t.set(firstNum, b + b / 2);
                    losser.add(firstNum);
                }
            }

            System.out.println(winner.toString());
            System.out.println(losser.toString());

            // Change num to loc
            // for (int i = 0; i < winner.size(); i++) {
            //     int winNum = idx.get(winner.get(i));
            //     winner.set(i, winNum);
            // }
            // for (int i = 0; i < losser.size(); i++) {
            //     int losNum = idx.get(losser.get(i));
            //     losser.set(i, losNum);
            // }


            // Add lost condition
            for (int j = 0; j < losser.size(); j++) {
                int cache = condition.get(losser.get(j));
                condition.set(losser.get(j), cache + 1);
            }
            System.out.println(condition.toString());
            

            // Detect is out m
            for (int j = idx.size() - 1; j >= 0; j--) {
                if (condition.get(idx.get(j) - 1) == m) {
                    losser.remove(idx.get(j));
                    idx.remove(idx.get(j));
                }
            }

            // Rebulid idx
            idx.clear();
                
            for (int j = 0; j < winner.size(); j++) {
                idx.add(winner.get(j));
            }
            for (int j = 0; j < losser.size(); j++) {
                idx.add(losser.get(j));
            }
            
            winner.clear();
            losser.clear();
            if (hasLast) idx.add(lastNum);
        }

        System.out.println(idx.get(0));
        scanner.close();
    }
}