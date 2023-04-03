import java.util.Arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class Bingo {

    private Scanner scan = new Scanner(System.in);
    private boolean win;
    private BingoCard emptybc;
    private OddOrEven bc;

    public Bingo(){
        emptybc = new BingoCard();
        bc = new OddOrEven("BINGO");
        win = false;
    }

    public void start() {
        emptybc.introduce();
        String ans = scan.nextLine();
        while (!ans.equals("yes")) {
            bc.introduce();
            ans = scan.nextLine();
        }
        System.out.print("Would you like to pick a bingo card with all (1) even numbers or all (2) odd numbers? ");
        int choice = scan.nextInt();
        if (choice == 1) {
            bc.setChoice(1);//sets to even
        } else if (choice == 2) {
            bc.setChoice(2);//sets to odd
        } else {
            while (choice != 1 && choice != 2){
                System.out.print("Would you like to pick a bingo card with all (1) even numbers or all (2) odd numbers? " );
                choice = scan.nextInt();
            }
        }
        scan.nextLine();
        bc.generateBingoCard();
        System.out.println("Lets start! 🙈");
        String answer = "";
        while(win!= true) {
            System.out.println(bc.grid());
            String prevRoll = bc.rolling();
            String currRoll = prevRoll;
            while (bc.getRolls().contains(currRoll)){
                currRoll = bc.rolling();
            }
            bc.setCurrRoll(currRoll);

            System.out.println("Rolling..." + currRoll);
            System.out.print("Do you have " + currRoll + "? ");
            answer = scan.nextLine();

            if (answer.equals("yes")) {
                if (bc.checkingSpot()){
                    System.out.println("You found a match!");
                } else {
                    System.out.println("Oh no, you don't have it! Don't lose hope!");
                }
            } else {
                System.out.println("Don't give up!");
            }

            System.out.println(bc.allRolls());

            if(bc.getRolls().size() > 150){
                System.out.println("You ran out of rolls! Better Luck next time!");
                break;
            }

            if (bc.checkBingo(bc.getBingoCard())){
                System.out.println("BINGO YAYA YOU WIN");
                win = true;
            }

        }
        scan.close();
        System.out.println(bc.grid());
    }
}
