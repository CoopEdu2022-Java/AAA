package chapter04.refect;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static int secretNumber;

    public static void main(String[] args) {
        Random random = new Random();
        secretNumber = random.nextInt(101);
        System.out.println("Guess a number (0-100): ");
        Scanner scanner = new Scanner(System.in);
        int guessedNumber = scanner.nextInt();
        String result = (guessedNumber == secretNumber) ? "Correct!" : "Wrong!";
        System.out.println(result + " The answer is: " + secretNumber);
        scanner.close();
    }
}