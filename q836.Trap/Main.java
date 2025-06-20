import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.valueOf(reader.readLine());
        String[] firstLine = reader.readLine().split(" ");
        int x1 = Integer.valueOf(firstLine[0]);
        int y1 = Integer.valueOf(firstLine[1]);
        String[] secondLine = reader.readLine().split(" ");
        int x2 = Integer.valueOf(secondLine[0]);
        int y2 = Integer.valueOf(secondLine[1]);
        int step = 0;

        while (k > 0) {
            step += k;
            if (step % x1 == 0) k -= y1;
            if (step % x2 == 0) k -= y2;
        }

        System.out.println(step);
    }
}