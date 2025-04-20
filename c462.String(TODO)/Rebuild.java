import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Rebuild {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine().split(" ")[0]);
        char[] line = reader.readLine().toCharArray();
        ArrayList<Integer> caseArr = new ArrayList<>();
        ArrayList<Integer> numArr = new ArrayList<>();
        ArrayList<Integer> kArr = new ArrayList<>();

        int consis = 1;
        for (int i = 0; i < line.length; i++) {
            boolean isUpper = Character.isUpperCase(line[i]);
            caseArr.add(isUpper ? 1 : 0);

            if (i != 0) {
                if (caseArr.get(i).equals(caseArr.get(i - 1))) consis += 1;
                else {
                    int cache = consis;
                    numArr.add(cache);
                    consis = 1;
                }
            }
        }
        numArr.add(consis);
        for (int i : numArr) {
            if (i > k) kArr.add(2);
            else if (i == k) kArr.add(1);
            else kArr.add(0);
        }
        // System.out.println(kArr.toString());

        // Get longest k
        int ans = 0;
        int cache = 0;
        for (int i = 0; i < kArr.size(); i++) {
            if (kArr.get(i) == 1) {
                cache += k;
            }
            else {
                if (i != 1 && i - cache / k > 0) {
                    if (kArr.get(i - 1 - cache / k) == 2) cache += k;
                }
                if (kArr.get(i) == 2) cache += k;
                
                if (ans < cache) {
                    ans = cache;
                    cache = 0;
                }
            }
        }
        // System.out.println(loc);
        // System.out.println(numArr.toString());
        // System.out.println(kArr.toString());
        // System.out.println(kArr.get(loc - ans / k));
       
        if (ans == 0) for (int i : kArr) if (i == 2) ans = k;

        System.out.println(ans);
    }
}
