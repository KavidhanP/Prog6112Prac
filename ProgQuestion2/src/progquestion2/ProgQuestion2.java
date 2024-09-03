
package progquestion2;

import java.util.Scanner;
import java.util.Random;

public class ProgQuestion2 {
     public  int range;
    public  int maxAttempts;
    public  int randomNumber;
    public  int attemptsMade;
    int guess;

    void main() {
       Scanner scanner = new Scanner(System.in);
        GameStatistics stats = new GameStatistics();
        
        
         while (true) {
            System.out.println("\nNumber Guessing Game");
            System.out.println("1. Start New Game");
            System.out.println("2. Choose Difficulty Level");
            System.out.println("3. View Statistics");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (range == 0) {
                        System.out.println("Please select a difficulty level first.");
                    } else {
                        playGame(scanner, stats);
                    }
                    break;

                case 2:
                    chooseDifficulty(scanner);
                    break;

                case 3:
                    stats.displayStatistics();
                    break;

                case 4:
                    System.out.println("Exiting game. ");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
  

    
   
  
        public void chooseDifficulty(Scanner scanner) {
        System.out.println("\nChoose Difficulty Level");
        System.out.println("1. Easy (Range: 1-10, Attempts: 5)");
        System.out.println("2. Medium (Range: 1-50, Attempts: 7)");
        System.out.println("3. Hard (Range: 1-100, Attempts: 9)");
        System.out.print("Select a difficulty: ");
        int levelChoice = scanner.nextInt();

        switch (levelChoice) {
            case 1:
                range = 10;
                maxAttempts = 5;
                break;

            case 2:
                range = 50;
                maxAttempts = 7;
                break;

            case 3:
                range = 100;
                maxAttempts = 9;
                break;

            default:
                System.out.println("Invalid choice. Defaulting to Easy level.");
                range = 10;
                maxAttempts = 3;
        }
        RandomNumber();
        System.out.println("Difficulty set. You can now start the game.");
    }
    
    
    
    public void RandomNumber(){
      Random rand = new Random();
        randomNumber = rand.nextInt(range) + 1;
        attemptsMade = 0;
    
    
    }
    
     public void playGame(Scanner scanner, GameStatistics stats) {
        stats.incrementGamesPlayed();
        System.out.println("\nStarting game at chosen difficulty...");
        System.out.println("Guess the number between 1 and " + range);
        System.out.println("You have " + maxAttempts + " attempts.");
        
        boolean win = false;
        
        while(attemptsMade < maxAttempts){
        guess = scanner.nextInt();
        attemptsMade++;
        
        
        if(guess == randomNumber){
        
        System.out.println("You win");
        
         win = true;
         stats.incrementGamesWon();
         stats.incrementGamesPlayed();
         break;
        }
        else if(guess < randomNumber){
        System.out.println("The number is too low");
        
        }
        else{
        
         System.out.println("The number is too high");
        }
        
        if (!win && attemptsMade == maxAttempts) {
            System.out.println(" You've used all attempts. The correct number was: " + randomNumber);
            stats.incrementGamesLost();
             stats.incrementGamesPlayed();
             break;
        }
     
    }
        
        
    
    }
     
    
    
    public class GameStatistics { // Change this to public
        private int gamesPlayed;
        private int gamesWon;
        private int gamesLost;

        public GameStatistics() {
            this.gamesPlayed = 0;
            this.gamesWon = 0;
            this.gamesLost = 0;
        }

        public void incrementGamesPlayed() {
            gamesPlayed++;
        }

        public void incrementGamesWon() {
            gamesWon++;
        }

        public void incrementGamesLost() {
            gamesLost++;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public int getGamesWon() {
            return gamesWon;
        }

        public int getGamesLost() {
            return gamesLost;
        }

        public void displayStatistics() {
            System.out.println("Game Statistics:");
            System.out.println("Games Played: " + gamesPlayed);
            System.out.println("Games Won: " + gamesWon);
            System.out.println("Games Lost: " + gamesLost);
        }
    }
    
}

