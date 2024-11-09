import java.util.Scanner;

public class NumberGuessingGame {
    int EASY_CHANCES = 10;
    int MEDIUM_CHANCES = 5;
    int HARD_CHANCES = 3;
    int RANDOM_NUMBER = (int) (Math.random() * 100) + 1;

    Scanner input = new Scanner(System.in);

    public void instructions() {
        System.out.println("Welcome to the Number Guessing Game!");

        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
    }

    public void difficulty() {
        instructions();
        System.out.print("Enter Your Choice: ");
        int userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                gameStart("Easy", EASY_CHANCES);
                break;
            case 2:
                gameStart("Medium", MEDIUM_CHANCES);
                break;
            case 3:
                gameStart("Hard", HARD_CHANCES);
                break;
            default:
                System.out.println("Invalid Choice! Please Try Again!");
        }

    }

    public void gameStart(String diffChoiced, int chances) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Great! You have selected the " + diffChoiced + " difficulty level.");
        System.out.println("Let's start the game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + chances + " chances to guess the correct number.\n");
        gameProcess(chances);
    }

    public void gameProcess(int chances) {
        int totalOfChances = chances;
        int attempts = 0;
        while (chances > 0) {
            System.out.print("Enter your guess: ");
            int guessedNum = input.nextInt();
            System.out.println(RANDOM_NUMBER);
            if (RANDOM_NUMBER != guessedNum) {
                if (RANDOM_NUMBER < guessedNum) {
                    System.out.println("Incorrect! The number is less than " + guessedNum);
                } else {
                    System.out.println("Incorrect! The number is greater than " + guessedNum);
                }
                chances--;
                attempts++;
            } else {
                break;
            }
        }
        if (chances == 0) {
            System.out.println("Oops! You’re out of chances! Better luck next time!");
        }
        System.out.println("Congratulations! You guessed the correct number in " + attempts + " out of " + totalOfChances + " attempts.");

    }

    public static void main(String[] args) {
        NumberGuessingGame guessingGame = new NumberGuessingGame();
        guessingGame.difficulty();
    }
}
