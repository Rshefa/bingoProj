import java.util.Arrays;//super
//https://www.arkadium.com/games/bingo/

public class BingoCard{
    private Square[][] bingoCard;

    public BingoCard() {
        bingoCard = new Square[5][5];
    }

    public Square[][] getBingoCard(){
        return bingoCard;
    }


    public void setBingoCard(Square[][] newBingoCard){
        bingoCard = newBingoCard;
    }

    public String grid(){
        return "---------------------------------------------------------"
                + "\n|    B     |    I     |    N     |    G     |     O     |"
                + "\n---------------------------------------------------------"
                + "\n|    " + bingoCard[0][0].getNumber() + "    |    " + bingoCard[0][1].getNumber() + "    |    " + bingoCard[0][2].getNumber() + "    |    " + bingoCard[0][3].getNumber() + "    |    " + bingoCard[0][4].getNumber() + "     |"
                + "\n---------------------------------------------------------"
                + "\n|    " + bingoCard[1][0].getNumber() + "    |    " + bingoCard[1][1].getNumber() + "    |    " + bingoCard[1][2].getNumber() + "    |    " + bingoCard[1][3].getNumber() + "    |    " + bingoCard[1][4].getNumber() + "     |"
                + "\n---------------------------------------------------------"
                + "\n|    " + bingoCard[2][0].getNumber() + "    |    " + bingoCard[2][1].getNumber() + "    |    " + bingoCard[2][2].getNumber() + "     |    " + bingoCard[2][3].getNumber() + "    |    " + bingoCard[2][4].getNumber() + "     |"
                + "\n---------------------------------------------------------"
                + "\n|    " + bingoCard[3][0].getNumber() + "    |    " + bingoCard[3][1].getNumber() + "    |    " + bingoCard[3][2].getNumber() + "    |    " +  bingoCard[3][3].getNumber() + "    |    " + bingoCard[3][4].getNumber() + "     |"
                + "\n---------------------------------------------------------"
                + "\n|    " + bingoCard[4][0].getNumber() + "    |    " + bingoCard[4][1].getNumber() + "    |    "  + bingoCard[4][2].getNumber() + "    |    " + bingoCard[4][3].getNumber() + "    |    " + bingoCard[4][4].getNumber() + "     |"
                + "\n---------------------------------------------------------";
    }

    public void introduce(){
        System.out.print("Hi there! Are you ready to play some BINGO? (the only answer is yes :D) ");
    }

}