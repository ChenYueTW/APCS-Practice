import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        int maxPoint = Integer.MIN_VALUE;
        int error = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int tNum = Integer.parseInt(line[0]);
            int sNum = Integer.parseInt(line[1]);
            t.add(tNum);
            s.add(sNum);
            if (sNum != -1) maxPoint = maxPoint < sNum ? sNum : maxPoint;
            if (sNum == -1) error += 1;
        }
        int firstMaxVal = 0;
        for (int i = 0; i < n; i++) {
            if (s.get(i) == maxPoint) break;
            firstMaxVal += 1;
        }
        int total = 0;
        total = maxPoint - n - error * 2;
        total = total < 0 ? 0 : total;
        System.out.println(total + " " + t.get(firstMaxVal));
        scanner.close();
    }
}