import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String fileName = "src/cars.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть марку автомобіля: ");
        String targetBrand = scanner.nextLine().trim();
        System.out.print("Введіть колір автомобіля: ");
        String targetColor = scanner.nextLine().trim();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;
            System.out.println("\nАвтомобілі марки " + targetBrand + " кольору " + targetColor + ":");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String brand = parts[0].trim();
                    String number = parts[1].trim();
                    String color = parts[2].trim();
                    String owner = parts[3].trim();
                    if (brand.equalsIgnoreCase(targetBrand) && color.equalsIgnoreCase(targetColor)) {
                        System.out.println("Номер: " + number + ", Власник: " + owner);
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Автомобілів з такими параметрами не знайдено.");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}
