import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Path filePath = Paths.get("src/file.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
    }
}
