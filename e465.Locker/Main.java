import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        int[] arr = new int[n];
        int total = 0;
        
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
            total += arr[i];
        }
        Arrays.sort(arr);
        total = m - total < 0 ? 0 : m - total;
        int cache = 0;

        for (int i = 0; i < n; i++) { // contorl 人數
            
        }
        System.out.println(cache);
    }
}
