import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int a = Integer.valueOf(line[0]);
        int b = Integer.valueOf(line[1]);
        int end = Integer.valueOf(line[2]);
        int cache = 0;

        if (isAnd(a, b, end)) {
            System.out.println("AND");
            cache += 1;
        }
        if (isOr(a, b, end)) {
            System.out.println("OR");
            cache += 1;
        }
        if (isXor(a, b, end)) {
            System.out.println("XOR");
            cache += 1;
        }
        if (cache == 0) System.out.println("IMPOSSIBLE");

        scanner.close();
    }

    public static boolean isAnd(int a, int b, int end) {
        return (a != 0 && b != 0) == (end == 0 ? false : true);
    }

    public static boolean isOr(int a, int b, int end) {
        return (a != 0 || b != 0) == (end == 0 ? false : true);
    }

    public static boolean isXor(int a, int b, int end) {
        if ((a != 0 && b != 0) || (a == 0 && b == 0)) {
            return false == (end == 0 ? false : true);
        } else if ((a != 0 && b == 0) || (b != 0 && a == 0)) {
            return true == (end == 0 ? false : true);
        }
        return false;
    }
}