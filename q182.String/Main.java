import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() % 2 != 0) {
            return;
        }
        int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        String p = "";
        for (int i = 0; i < n; i++) {
            int nn = Integer.valueOf(scanner.nextLine().split(" ")[0]);
            if (nn == 0) p = twoChange(i == 0 ? s : p);
            else if (nn == 1) p = twoSplit(i == 0 ? s : p);
            else if (nn == 2) p = beauty(i == 0 ? s : p);
        }

        System.out.println(p);
        scanner.close();
    }

    public static String twoChange(String string) {
        int length = string.length();
        String a = "";
        String[] f = new String[length / 2];
        for (int i = 0; i < length / 2; i++) {
            f[i] = string.substring((i * 2 + 1), (i * 2 + 2)) + string.substring((i * 2), (i * 2 + 1));
        }
        
        for (int i = 0; i < f.length; i++) {
            a += f[i];
        }
        return a;
    }

    public static String twoSplit(String string) {
        int length = string.length();
        String a = "";
        String[] f = new String[length / 2];
        for (int i = 0; i < length / 2; i++) {
            String first = string.substring((i * 2 + 1), (i * 2 + 2));
            String second = string.substring((i * 2), (i * 2 + 1));
            if (first.compareTo(second) < 0) f[i] = first + second;
            else if (first.compareTo(second) > 0) f[i] = second + first;
            else f[i] = first + second;
        }

        for (int i = 0; i < f.length; i++) {
            a += f[i];
        }
        return a;
    }

    public static String beauty(String string) {
        int n = string.length();
        String[] f = new String[n / 2];
        String a = "";
        String first = string.substring(0, n / 2);
        String second = string.substring(n / 2, n);

        for (int i = 0; i < n / 2; i++) {
            f[i] = first.substring(i, i + 1) + second.substring(i, i + 1);
        }

        for (int i = 0; i < f.length; i++) {
            a += f[i];
        }
        return a;
    }
}