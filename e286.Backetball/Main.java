import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMain = scanner.nextLine().split(" ");
        String[] firstVice = scanner.nextLine().split(" ");
        int firstMainPoint = 0;
        int firstVicePoint = 0;

        for (int i = 0; i < 4; i++) {
            firstMainPoint += Integer.valueOf(firstMain[i]);
        }
        for (int i = 0; i < 4; i++) {
            firstVicePoint += Integer.valueOf(firstVice[i]);
        }

        String[] secondMain = scanner.nextLine().split(" ");
        String[] secondVice = scanner.nextLine().split(" ");
        int secondMainPoint = 0;
        int secondVicePoint = 0;

        for (int i = 0; i < 4; i++) {
            secondMainPoint += Integer.valueOf(secondMain[i]);
        }
        for (int i = 0; i < 4; i++) {
            secondVicePoint += Integer.valueOf(secondVice[i]);
        }

        System.out.println(firstMainPoint + ":" + firstVicePoint);
        System.out.println(secondMainPoint + ":" + secondVicePoint);
        if (firstMainPoint > firstVicePoint && secondMainPoint > secondVicePoint) System.out.println("Win");
        else if (firstMainPoint < firstVicePoint && secondMainPoint < secondVicePoint) System.out.println("Lose");
        else System.out.println("Tie");
        scanner.close();
    }
}