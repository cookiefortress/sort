import java.io.*;
import java.util.*;

public class Loader {
    public static int[] load(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
