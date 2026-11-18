package Part1;
import java.util.Scanner;

public class Assignment11Part1 {
    public static Scanner scanner = new Scanner(System.in);
    public static int getValidInputSafe(int min, int max) {
        int value = 0;
        while (value<min||value>max) {

            // First, make sure it's a number
            while (!scanner.hasNextInt()) {//cin.hasNextInt() returns true if the next input can be read as an integer, false otherwise.
                IO.println("That's not a number! Try again:");
                scanner.next();
                IO.println(scanner);
            }

            value = scanner.nextInt();
            // Then check if it's in range
            if (value<min||value>max) {
                IO.println("Invalid! Must be between 1 and 999\n");
            }
        }
        return value;
    }
    public static void main(String[] args) {

        Geek geek = new Geek("Geek", 0);

        String menu =
                "Command Options\n" +
                        "--------------------\n" +
                        "a: get name\n" +
                        "b: number of questions asked\n" +
                        "c: sum is even\n" +
                        "d: sum between two integers\n" +
                        "e: leap year\n" +
                        "?: display the menu again\n" +
                        "q: quit this program";

        System.out.println(menu);

        boolean running = true;

        while (running) {
            System.out.print("Please enter a command or type ?: ");
            String command = scanner.next();

            switch (command) {
                case "a": {
                    System.out.println("Name: " + geek.getName());
                    break;
                }

                case "b": {
                    System.out.println(
                            "Number of questions: " + geek.getNumberOfQuestions()
                    );
                    break;
                }

                case "c": {
                    System.out.print("Enter the first number: ");
                    int num1 = getValidInputSafe(-2147483648,2147483647);

                    System.out.print("Enter the second number: ");
                    int num2 = getValidInputSafe(-2147483648,2147483647);

                    if (geek.isEven(num1, num2)) {
                        System.out.println("The sum of the numbers is even");
                    } else {
                        System.out.println("The sum of the numbers is odd");
                    }
                    break;
                }

                case "d": {
                    System.out.print("Enter the first number: ");
                    int num1 = getValidInputSafe(-2147483648,2147483647);

                    System.out.print("Enter the second number: ");
                    int num2 = getValidInputSafe(-2147483648,2147483647);

                    int result = geek.sum(num1, num2);

                    System.out.println(
                            "The sum between " + Math.min(num1, num2) +
                                    " and " + Math.max(num1, num2) +
                                    " is " + result
                    );
                    break;
                }

                case "e": {
                    System.out.print("Enter a year: ");
                    int year = scanner.nextInt();

                    if (geek.leapYear(year)) {
                        System.out.println(year + " is a leap year");
                    } else {
                        System.out.println(year + " is not a leap year");
                    }
                    break;
                }

                case "?": {
                    System.out.println(menu);
                    break;
                }

                case "q": {
                    running = false;
                    break;
                }

                default: {
                    System.out.println("Unknown command. Type ? to see the menu.");
                    break;
                }
            }
        }


    }
}