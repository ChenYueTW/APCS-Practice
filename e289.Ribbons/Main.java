import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Main {
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

        HashMap<BigInteger, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        if (map.size() == m) ans++;

        for (int i = 1; i <= n - m; i++) {
            map.put(array[i - 1], map.get(array[i - 1]) - 1);
            if (map.get(array[i - 1]) == 0) map.remove(array[i - 1]);

            map.put(array[i + m - 1], map.getOrDefault(array[i + m - 1], 0) + 1);
            if (map.size() == m) ans++;
        }
        System.out.println(ans);
    }
}