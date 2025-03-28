import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        Long[] w = new Long[100];

        while (scanner.hasNextLine()) {
            w[m] = Long.valueOf(scanner.nextLine());
            m += 1;
        }
        Long[] n = new Long[m];
        for (int i = 0; i < m; i++) {
            n[i] = w[i];
        }

        for (int i = 0; i < n.length; i++) {
            Long upOdd = getUpOdd(n[i]);
            Long downOdd = getDownOdd(n[i]);
            if (Math.abs(upOdd - n[i]) <= Math.abs(downOdd - n[i])) {
                System.out.println(upOdd - n[i]);
            } else {
                System.out.println(n[i] - downOdd);
            }
        }
        scanner.close();
    }

    public static Long getUpOdd(Long n) {
        int length = (int) Math.log10(n) + 1;
        int[] array = new int[length];

        for (Long i = n; true;) {
            length = (int) Math.log10(i) + 1;
            array = new int[length];
            // Num to Array
            for (int j = length - 1; j >= 0; j--) {
                array[j] = (int) (i % 10);
                i /= 10;
            }
    
            // Detect is K
            Long cache = 0L;
            boolean isCorrect = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] % 2 == 0) {
                    isCorrect = true;
                    // Cache (% 2 = 0) num
                    cache += ((array[j] + 1) * (long) Math.pow(10, array.length - j - 1));
                    break;
                }
                cache += (array[j] * (long) Math.pow(10, array.length - j - 1));
            }
            if (!isCorrect) return cache;
            i = cache;
        }
    }

    public static Long getDownOdd(Long n) {
        int length = (int) Math.log10(Math.abs(n)) + 1;
        int[] array = new int[length];

        for (Long i = Math.abs(n); i > 0;) {
            length = (int) Math.log10(i) + 1;
            array = new int[length];
            // Num to Array
            for (int j = length - 1; j >= 0; j--) {
                array[j] = (int) (i % 10);
                i /= 10;
            }
    
            // Detect is K
            Long cache = 0L;
            boolean isCorrect = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] % 2 == 0) {
                    isCorrect = true;
                    // Cache (% 2 = 0) num
                    cache += ((array[j]) * (long) Math.pow(10, array.length - j - 1));
                    cache -= 1;
                    break;
                }
                cache += (array[j] * (long) Math.pow(10, array.length - j - 1));
            }
            if (!isCorrect) return cache * (n >= 0 ? 1 : -1);
            i = cache;
        }
        return 1L;
    }
}
