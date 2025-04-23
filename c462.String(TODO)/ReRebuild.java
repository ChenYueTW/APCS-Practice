import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReRebuild {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        char[] line = reader.readLine().toCharArray();

        ArrayList<Integer> isCase = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            isCase.add('A' <= line[i] && line[i] <= 'Z' ? 1 : 0);
        }

        ArrayList<Integer> numArr = new ArrayList<>();
        int numCache = 1;
        for (int i = 0; i < isCase.size() - 1; i++) {
            if (isCase.get(i) == isCase.get(i + 1)) numCache++;
            else {
                int cache = numCache;
                numArr.add(cache);
                numCache = 1;
            }
            if (i == isCase.size() - 2) numArr.add(numCache);
        }

        int length = 0;
        int unitCache = 0;
        int endLoc = 0;
        for (int i = 0; i < numArr.size(); i++) {
            if (numArr.get(i) == k) unitCache++;
            else {
                if (unitCache > length) {
                    length = unitCache;
                    unitCache = 0;
                    endLoc = i;
                }
            }

            if (i == numArr.size() - 1) {
                if (unitCache > length) {
                    length = unitCache;
                    unitCache = 0;
                    endLoc = i;
                }
            }
        }
        if (length == 0) for (int i : numArr) if (i > k) length = k;

        System.out.println(length);
        System.out.println(isCase.toString());
        System.out.println(numArr.toString());
    }
}
