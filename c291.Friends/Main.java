import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        int[] initArray = new int[n];
        int[] friendsArray = new int[n];
        boolean[] isSearched = new boolean[n];
        int groups = 0;

        for (int i = 0; i < isSearched.length; i++) {
            isSearched[i] = false;
        }
        for (int i = 0; i < n; i++) {
            initArray[i] = i;
        }
        String[] friends = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            friendsArray[i] = Integer.valueOf(friends[i]);
        }

        // Proccess
        for (int i = 0; i < n; i++) {
            if (!isSearched[i]) {
                if (initArray[i] == friendsArray[i]) { // Only one
                    isSearched[i] = true;
                    groups += 1;
                } else {
                    boolean isFinished = false;
                    int cache = initArray[i];
                    while (!isFinished) {
                        int friend = friendsArray[cache];
                        isSearched[cache] = true;
                        cache = initArray[friend];
                        if (initArray[i] == cache) {
                            isFinished = true;
                        }
                    }
                    groups += 1;
                }
            }
        }

        System.out.println(groups);
        scanner.close();
    }
}