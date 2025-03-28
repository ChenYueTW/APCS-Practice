import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int student = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        String[] score = scanner.nextLine().split(" ");
        int[] scoreArray = new int[student];

        for (int i = 0; i < scoreArray.length; i++) {
            scoreArray[i] = Integer.valueOf(score[i]);
        }

        Arrays.sort(scoreArray);
        for (int i = 0; i < scoreArray.length; i++) {
            System.out.print(scoreArray[i] + (i == scoreArray.length - 1 ? "" : " "));
        }

        int cc = -1;
        for (int i = 0; i < scoreArray.length; i++) {
            if (scoreArray[i] < 60 && scoreArray[i] > cc) cc = scoreArray[i];
        }
        if (cc == -1) {
            System.out.println("\nbest case");
        } else {
            System.out.println("\n" + cc);
        }

        cc = 1000;
        for (int i = 0; i < scoreArray.length; i++) {
            if (scoreArray[i] >= 60 && scoreArray[i] < cc) cc = scoreArray[i];
        }
        if (cc == 1000) {
            System.out.println("worst case");
        } else {
            System.out.println(cc);
        }
    }
}