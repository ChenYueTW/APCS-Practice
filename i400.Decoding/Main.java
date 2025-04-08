import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(scanner.nextLine().split(""));
        }
        
        String[] tArr = scanner.nextLine().split("");
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            t.add(tArr[i]);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            ArrayList<String> s = new ArrayList<>();

            int eNum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (list.get(i)[j].equals("0")) {
                    String lastString = t.get(t.size() - 1);
                    s.add(0, lastString);
                    t.remove(t.size() - 1);
                } else {
                    String lastString = t.get(t.size() - 1);
                    s.add(lastString);
                    t.remove(t.size() - 1);
                    eNum += 1;
                }
            }

            if (eNum % 2 != 0) { // Step 1
                String[] forward = new String[n / 2];
                for (int j = 0; j < n / 2; j++) {
                    forward[j] = s.get(j);
                }
                String[] back = new String[n / 2];
                for (int j = n / 2 + (n % 2 == 0 ? 0 : 1), k = 0; j < n; j++, k++) {
                    back[k] = s.get(j);
                }

                // Add to arr
                String middle = "";
                if (n % 2 != 0) middle = s.get(n / 2);
                t.clear();
                for (int j = 0; j < n / 2; j++) {
                    t.add(back[j]);
                }
                if (n % 2 != 0) t.add(middle);
                for (int j = 0; j < n / 2; j++) {
                    t.add(forward[j]);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    t.add(s.get(j));
                }
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.print(t.get(j));
        }
        scanner.close();
    }
}