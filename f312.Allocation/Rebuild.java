import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Rebuild {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Character> test = new HashMap<>();
        test.put("0 1 0 1", 'A');
        test.put("0 1 1 1", 'B');
        test.put("0 0 1 0", 'C');
        test.put("1 1 0 1", 'D');
        test.put("1 0 0 0", 'E');
        test.put("1 1 0 0", 'F');

        String line;
        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line);
            StringBuilder cache = new StringBuilder();

            for (int i = 0; i < n; i++) {
                cache.append(test.get(reader.readLine()));
            }

            System.out.println(cache);
        }
    }
}
