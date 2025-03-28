import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        int[] m = new int[a.length];

        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.valueOf(a[i]);
        }
        Arrays.sort(m);

        if (m[0] + m[1] <= m[2]) {
            System.out.println(m[0] + " " + m[1] + " " + m[2]);
            System.out.println("No");
        } else if (m[0] * m[0] + m[1] * m[1] < m[2] * m[2]) {
            System.out.println(m[0] + " " + m[1] + " " + m[2]);
            System.out.println("Obtuse");
        } else if (m[0] * m[0] + m[1] * m[1] == m[2] * m[2]) {
            System.out.println(m[0] + " " + m[1] + " " + m[2]);
            System.out.println("Right");
        } else if (m[0] * m[0] + m[1] * m[1] > m[2] * m[2]) {
            System.out.println(m[0] + " " + m[1] + " " + m[2]);
            System.out.println("Acute");
        }
        scanner.close();
    }
}