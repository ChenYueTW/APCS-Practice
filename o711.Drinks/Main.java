import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
        String[] firstLine = scanner.nextLine().split(" ");
        int w1 = Integer.valueOf(firstLine[0]);
        int w2 = Integer.valueOf(firstLine[1]);
        int h1 = Integer.valueOf(firstLine[2]);
        int h2 = Integer.valueOf(firstLine[3]);
        int[] mol = new int[n];
        int[] deltaHeight = new int[n];
        int firstMol = w1 * w1 * h1;
        int secondMol = w2 * w2 * h2;
        int totalHeight = 0;

        // Get drinks mol
        String[] drinksMol = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            mol[i] = Integer.valueOf(drinksMol[i]);
        }

        for (int i = 0; i < mol.length; i++) {
            int h = 0;
            if (totalHeight == 0) {
                if (mol[i] > firstMol + secondMol) {
                    h = h1 + h2;
                } else if (mol[i] > firstMol) {
                    h = h1 + ((mol[i] - firstMol) / (w2 * w2));
                } else {
                    h = mol[i] / (w1 * w1);
                }
            } else if (totalHeight >= h1 + h2) {
                h = 0;
            } else {
                if (totalHeight > h1) {
                    if (totalHeight + (mol[i] / (w2 * w2)) > h1 + h2) {
                        h = (h1 + h2) - totalHeight;
                    } else {
                        h = mol[i] / (w2 * w2);
                    }
                } else {
                    if (totalHeight + (mol[i] / (w1 * w1)) > h1) {
                        int molH1 = h1 - totalHeight;
                        int molM1 = w1 * w1 * molH1;
                        int molH2 = (mol[i] - molM1) / (w2 * w2);
                        if (molH2 >= h2) {
                            h = molH1 + h2;
                        } else {
                            h = molH1 + molH2;
                        }
                    } else {
                        h = mol[i] / (w1 * w1);
                    }
                }
            }
            deltaHeight[i] = h;
            totalHeight += h;
        }

        // get max delta height
        int cache = 0;
        for (int i = 0; i < deltaHeight.length; i++) {
            cache = deltaHeight[i] > cache ? deltaHeight[i] : cache;
        }
        System.out.println(cache);
        scanner.close();
    }
}