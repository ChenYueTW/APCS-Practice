import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<HashSet<String>> sets = new ArrayList<>();
        
        int n = Integer.valueOf(reader.readLine());
        String[] arr = new String[n];
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            HashSet<String> stringSet = new HashSet<>();
            arr[i] = line;
            String[] lines = line.split("");
            for (int j = 0; j < lines.length; j++) {
                stringSet.add(lines[j]);
            }
            sets.add(stringSet);
            minSize = minSize < stringSet.size() ? minSize : stringSet.size();
        }

        // Get min array
        ArrayList<String> minArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (sets.get(i).size() == minSize) minArr.add(arr[i]);
        }

        System.out.println(compare(minArr, minSize));
    }

    public static String compare(ArrayList<String> arr, int minSize) {
        for (int i = 0; i < minSize; i++) {
            char minChar = 'Z';
            for (int j = 0; j < arr.size(); j++) {
                char arrChar = arr.get(j).toCharArray()[i];
                if (minChar >= arrChar) minChar = arrChar;
                else arr.remove(j);
            }
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j).toCharArray()[i] != minChar) arr.remove(j);
            }
            if (arr.size() == 1) return arr.get(0);
        }
        return "Error";
    }
}