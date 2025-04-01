import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;

public class Rebuild {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int m = Integer.valueOf(firstLine[0]);
        int n = Integer.valueOf(firstLine[1]);
        BigInteger[] array = new BigInteger[n];

        String[] rainbow = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = new BigInteger(rainbow[i]);
        }

        System.out.println(process(array, n, m));
    }

    public static Long process(BigInteger[] array, int n, int m) {
        HashSet<BigInteger> set = new HashSet<>();
        Long ans = 0L;
        boolean init = false;

        for (int i = 0; i < m; i++) {
           if (!set.add(array[i])) init = true;
        }

        if (!init) ans += 1;

        for (int i = 1; i <= n - m; i++) {
            set.remove(array[i - 1]);
            if (!set.add(array[i + m - 1])) continue;
            ans += 1;
        }
        return ans;
    }
}