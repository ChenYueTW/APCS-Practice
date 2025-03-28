import java.util.Scanner;

public class Main {
    static int row = 0;
    static int column = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        row = Integer.valueOf(firstLine[0]);
        column = Integer.valueOf(firstLine[1]);
        int m = Integer.valueOf(firstLine[2]);
        int[][] array = new int[row][column];
        int[] move = new int[m];

        // Create array
        for (int i = 0; i < row; i++) {
            String[] rowNum = scanner.nextLine().split(" ");
            for (int j = 0; j < rowNum.length; j++) {
                array[i][j] = Integer.valueOf(rowNum[j]);
            }
        }

        // Movement with array
        String[] moveStr = scanner.nextLine().split(" ");
        for (int i = 0; i < moveStr.length; i++) {
            move[i] = Integer.valueOf(moveStr[i]);
        }

        for (int i = 0; i < move.length; i++) {
            int k = move[move.length - i - 1];
            if (k == 0) array = rotate(array, row, column);
            else if (k == 1) array = change(array, row, column);
        }

        // print out
        System.out.println(row + " " + column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + (j == column - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    public static int[][] change(int[][] array, int row, int column) {
        int[][] newArray = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newArray[i][j] = array[row - i -1][j];
            }
        }
        return newArray;
    }

    public static int[][] rotate(int[][] array, int row, int column) {
        int[][] newArray = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newArray[column - j - 1][i] = array[i][j];
            }
        }
        Main.row = column;
        Main.column = row;
        return newArray;
    }
}