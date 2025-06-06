import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IntegerDatasetGenerator {

    public static void generateFile(String filename, int numberCount) {
        Random rand = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberCount; i++) {
                int num = rand.nextInt(Integer.MAX_VALUE);
                writer.write(Integer.toString(num));
                writer.newLine();
            }
            System.out.println("Generated file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000, 10000000};

        for (int size : sizes) {
            String filename = "dataset_" + size + ".txt";
            generateFile(filename, size);
        }
    }
}
