package home.dbarannik.ConsoleReader;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner console = new Scanner(System.in);

    public int getValidInputInt(int lowerLimit, int upperLimit) {
        while (true) {
            int inputInt;
            if (console.hasNextInt()) {
                inputInt = console.nextInt();
                if (inputInt >= lowerLimit && inputInt <= upperLimit) {
                    return inputInt;
                } else {
                    System.out.println("Invalid input! Try again...");
                }
            } else {
                System.out.println("Invalid input! Try again...");
                console.next();
            }
        }
    }

    public float getValidInputFloat(float lowerLimit, float upperLimit) {
        while (true) {
            float inputFloat;
            if (console.hasNextFloat()) {
                inputFloat = console.nextFloat();
                if (inputFloat >= lowerLimit && inputFloat <= upperLimit) {
                    return inputFloat;
                } else {
                    System.out.println("Invalid input! Try again...");
                }
            } else {
                System.out.println("Invalid input! Try again...");
                console.next();
            }
        }
    }

    public String getInputString() {
        while (true) {
            if (console.hasNextLine()) {
                return console.nextLine();
            } else {
                System.out.println("Invalid input! Try again...");
                console.next();
            }
        }
    }
}
