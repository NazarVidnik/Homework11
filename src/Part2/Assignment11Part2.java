import Part2.Pizza;
import java.util.Scanner;
public static Scanner scanner = new Scanner(System.in);

public static double getValidInputSafe(int min, int max) {
    double value;

    do {
        while (!scanner.hasNextDouble()) {
            System.out.println("That's not a number! Try again:");
            scanner.nextLine();
        }

        value = scanner.nextDouble();
        scanner.nextLine(); // Прибираємо залишок рядка після числа.

        if (!Double.isFinite(value) || value < min || value > max) {
            System.out.println(
                    "Invalid! Must be between " + min + " and " + max
            );
        }
    } while (!Double.isFinite(value) || value < min || value > max);

    return value;
}

public static void main(String[] args) {
    Pizza[] pizzas = new Pizza[5];
for (int i =0; i<pizzas.length;i++) {
    IO.println("Hello! enter name of your new pizza:");
    String n = scanner.nextLine();
    IO.println("Hello! enter price of your new pizza:");

    double p = getValidInputSafe(0, 10000);
    pizzas[i] = new Pizza(n, p);
}
    for (int i = 0; i < pizzas.length - 1; i++) { //bubble sort algo
        for (int j = 0; j < pizzas.length - 1 - i; j++) {
            if (pizzas[j].getPrice() > pizzas[j + 1].getPrice()) {
                Pizza buffer = pizzas[j];
                pizzas[j] = pizzas[j + 1];
                pizzas[j + 1] = buffer;
            }
        }
    }
    for (int i = 0; i < pizzas.length; i++) {
        IO.println(pizzas[i].toString());
    }
}