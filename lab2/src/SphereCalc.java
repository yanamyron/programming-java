import java.util.Scanner;

public class SphereCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть радіус сфери:");
        double radius = scanner.nextDouble();

        double sphereVol = (4 / 3 ) * Math.PI* Math.pow(radius,3);
        double cubeSide =(2 * radius) / Math.sqrt(3);
        double cubeSurArea = 6 * Math.pow(cubeSide,2);

        System.out.print("Об'єм кулі:"+ sphereVol);
        System.out.print("Площа поверхні вписаного куба:"+cubeSurArea);

        scanner.close();
    }
}