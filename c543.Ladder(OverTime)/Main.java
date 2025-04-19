import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] n = new long[100];
        int k = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            n[k] = Long.valueOf(line);
            k += 1;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(getLadder(n[i]));
        }
    }

    public static int getLadder(Long n) {
        int cache = 0;
        for (Long i = 1L; i <= n;) {
            if (isLadder(i)) {
                cache += 1;
                i += 1;
            } else {
                Long value = optimizeI(i);
                if (value == i) System.out.println("FFFFFF");
                i = value;
            }
        }
        return cache;
    }

    public static boolean isLadder(Long n) {
        int length = (int) Math.log10(n) + 1;
        Long[] array = new Long[length];

        for (int i = length - 1; i >= 0; i--) {
            array[i] = n % 10;
            n /= 10;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static Long optimizeI(Long n) {
        int length = (int) Math.log10(n) + 1;
        Long[] array = new Long[length];
        Long cache = 0L;

        for (int i = length - 1; i >= 0; i--) {
            array[i] = n % 10;
            n /= 10;
        }

        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                cache += (array[i] * (long) Math.pow(10, length - i - 1));
                cache += (array[i] * (long) Math.pow(10, length - i - 2));
                return cache;
            }
            cache += (array[i] * (int) Math.pow(10, length - i - 1));
        }
        return -1L;
    }
}