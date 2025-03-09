import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.print("Введіть стрічку:");
        String input = scanner.nextLine();

        byte[] utf8Bytes = input.getBytes(StandardCharsets.UTF_8);
        String converted = new String(utf8Bytes, java.nio.charset.Charset.forName("CP1251"));

        System.out.println("Перекодована стрічка(СР1251):" + converted);
        scanner.close();

    }
}