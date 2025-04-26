import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<int[]> read = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            read.add(new int[]{start, end});
        }

        read.sort(Comparator.comparingInt(a -> a[0]));

        int start = read.get(0)[0];
        int end = read.get(0)[1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (read.get(i)[0] > end) {
                ans += end - start;
                start = read.get(i)[0];
                end = read.get(i)[1];
            } else {
                end = Math.max(read.get(i)[1], end);
            }
        }
        ans += end - start;
        System.out.println(ans);
    }
}
