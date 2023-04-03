import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;


public class OddOrEven extends BingoCard { //PRINTS BOTH EVEN AND ODD
    private String category;
    private int generateNum;
    private int choice;
    private int randomLetter; //for roll
    private int randomNumber; //for roll
    private String letter;
    private Square[][] newCard;
    private String currRoll;
    private ArrayList<String> rolls;
    private boolean stop;

    public OddOrEven(String category1){
        super();
        this.category = category1;
        generateBingoCard();
        randomLetter = 0;
        randomNumber = 0;
        letter = "";
        rolls = new ArrayList<>();
        currRoll = "";
        stop = false;
    }

    public void setChoice(int newChoice){
        this.choice = newChoice;
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public int getRandomLetter(){ //position
        return randomLetter;
    }

    public String getLetter() { //actual letter
        return letter;

    }

    public boolean getStopRoll(){
        return stop;
    }

    public ArrayList<String> getRolls(){
        return rolls;
    }



    public int getChoice(){
        return choice;
    }

    public String getCurrRoll(){
        return currRoll;
    }

    public void setCurrRoll(String newCurrRoll){
        currRoll = newCurrRoll;
    }

    @Override
    public void introduce(){
        System.out.print("SAY yes: ");
    }

    public void generateBingoCard(){
        newCard = getBingoCard();
        Square s1 = new Square (category, oddOrEven());
        Square s2 = new Square (category, oddOrEven());
        Square s3 = new Square (category, oddOrEven());
        Square s4 = new Square (category, oddOrEven());
        Square s5 = new Square (category, oddOrEven());
        Square s6 = new Square (category, oddOrEven());
        Square s7 = new Square (category, oddOrEven());
        Square s8 = new Square (category, oddOrEven());
        Square s9 = new Square (category, oddOrEven());
        Square s10 = new Square (category, oddOrEven());
        Square s11 = new Square (category, oddOrEven());
        Square s12 = new Square (category, oddOrEven());
        Square s13 = new Square (category, 00);
        Square s14 = new Square (category, oddOrEven());
        Square s15 = new Square (category, oddOrEven());
        Square s16 = new Square (category, oddOrEven());
        Square s17 = new Square (category, oddOrEven());
        Square s18 = new Square (category, oddOrEven());
        Square s19 = new Square (category, oddOrEven());
        Square s20 = new Square (category, oddOrEven());
        Square s21 = new Square (category, oddOrEven());
        Square s22 = new Square (category, oddOrEven());
        Square s23 = new Square (category, oddOrEven());
        Square s24 = new Square (category, oddOrEven());
        Square s25 = new Square (category, oddOrEven());

        newCard = new Square[][]{{s1, s2, s3, s4, s5},
                {s6, s7, s8, s9, s10},
                {s11, s12, s13, s14, s15},
                {s16, s17, s18, s19, s20},
                {s21, s22, s23, s24, s25}};

        setBingoCard(newCard);
    }

    public String rolling(){
        randomLetter = (int) (Math.random() * 5 + 1);
        if(randomLetter == 1) {
            letter = "B";
        } else if (randomLetter == 2) {
            letter = "I";
        } else if (randomLetter == 3) {
            letter = "N";
        } else if (randomLetter == 4) {
            letter = "G";
        } else if (randomLetter == 5) {
            letter = "O";
        }

        randomNumber = oddOrEven();

        return letter + randomNumber;
    }

    public ArrayList<String> allRolls(){
        rolls.add(currRoll);
        return rolls;
    }

    //needs to be fixed
    public boolean checkingSpot(){
        boolean isFound = false;
        int num = extractNumber(currRoll);//num of roll
        int letterCol = getRandomLetter() - 1; //col of the letter
        int prevRow = letterCol;
        // letterCol = getRandomLetter() - 1; //row of the letter
        for(int row = 0; row < newCard[letterCol].length; row++){ //to check all the numbers in the specific row
            if (num == newCard[row][letterCol].getNumber()) {
                letterCol = prevRow;
                newCard[row][letterCol].setNumber(0);
                isFound = true;
            }

        }
        return isFound;
    }




    public boolean checkBingo(Square[][] board){
        boolean hasBingo = false;
        //checks rows
//        int bingo = 0;
//        int rowSum = 0;
//        int colSum = 0;
//        int diag1Sum = 0;
//        int diag2Sum = 0;

        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length - 1; col++) {
                int currVal = board[row][col].getNumber();
                int rightVal = board[row][col + 1].getNumber();
                while (board.length < 5) {
                    if (currVal == rightVal) {
                        hasBingo = true;
                    }
                }
            }
        }

        //checks columns
        for (int col = 0; col < board[0].length; col ++) {
            for (int row = 0; row < board.length - 1; row++) {
                int currVal = board[row][col].getNumber();
                int nextVal = board[row + 1][col].getNumber();
                while (board.length < 5) {
                    if (currVal == nextVal) {
                        hasBingo = true;
                    }
                }
            }
        }

        //checks diagonal from top left to bottom right
        for (int i = 0; i < board.length - 1; i++){
            int currVal = board[i][i].getNumber();
            int nextVal = board[i+1][i+1].getNumber();
            while (board.length < 5) {
                if (currVal == nextVal) {
                    hasBingo = true;
                }
            }
        }

        //check diagonal from top right to bottom left
        for (int i = 0; i < board.length; i++) {
            int j = 0;
            int currVal = board[i][4 - j].getNumber();
            j++;
            int nextVal = board[i][4 - j].getNumber();
            while (board.length < 5) {
                if (currVal == nextVal) {
                    hasBingo = true;
                }
            }
        }

        return hasBingo;
    }

    private String extractLetter(String str){
        return str.substring(0,1);
    }

    private int extractNumber(String str) {
        str = str.substring(1);
        return Integer.parseInt(str);
    }

    //helper method
    private int oddOrEven(){
        if (getChoice() == 1){
            generateNum = evenNum();
        } else if (getChoice() == 2){
            generateNum = oddNum();
        }
        return generateNum;
    }

    private int evenNum(){
        Random rand = new Random();
        int evenNum = 10 +rand.nextInt((70-10)/2) *2;
        return evenNum;
        // https://stackoverflow.com/questions/33870759/generate-a-random-even-number-inside-a-range#:~:text=it%20by%202.-,Random%20rand%20%3D%20new%20Random()%3B%20int%20randomNum%20%3D%20rand.,int %20randomNum%20%3D%20startOfRange%2Brand.
    }

    private int oddNum(){
        int oddNum = 0;
        oddNum = (int) (Math.random() * 50);
        oddNum = oddNum * 2 + 1;
        if (oddNum < 10){
            oddNum += 10;
        }
        return oddNum;
    }

}