import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> k = new ArrayList<>();

        while (scanner.hasNextLine()) {
            int n = Integer.valueOf(scanner.nextLine());
            String cache = "";
            for (int i = 0; i < n; i++) {
                String[] s = scanner.nextLine().split(" ");
                cache += getEncode(s);
            }
            k.add(cache);
        }

        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i));
        }
        scanner.close();
    }

    public static String getEncode(String[] line) {
        if (line[0].equals("0")) { // ABC
            if (line[1].equals("1")) { // AB
                if (line[2].equals("0")) return "A";
                else return "B";
            } else return "C";
        } else { // DEF
            if (line[1].equals("1")) { // DF
                if (line[3].equals("1")) return "D";
                else return "F";
            } else return "E";
        }
    }
}