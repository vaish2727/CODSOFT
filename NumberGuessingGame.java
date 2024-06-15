import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 10;  // Maximum attempts per round
        int totalScore = 0;    // User's total score
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int numberOfTries = 0;
            boolean win = false;

            System.out.println("\nI have selected a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");
            
            while (numberOfTries < maxAttempts && !win) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    win = true;
                    int roundScore = maxAttempts - numberOfTries + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                    System.out.println("You scored " + roundScore + " points this round. Total score: " + totalScore);
                }
            }

            if (!win) {
                System.out.println("You've used all your attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + totalScore);
        scanner.close();
    }
}
