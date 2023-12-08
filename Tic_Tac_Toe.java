import java.util.Scanner;
// Author: Darshil G V
public class Tic_Tac_Toe {
    public static void main(String[] args) {
        Start st = new Start();
    }
}

class Start {
    char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    Scanner in=new Scanner(System.in);
    public boolean insert(int p, char id) {
        int oi=(p<=3 && p>=1)?0:(p<=6)?1:2;
        int ii=(p<=3 && p>=1)?p-1:(p<=6)?p-4:p-7;
        if(board[oi][ii] == ' '){
            board[oi][ii]=id;
            return true;
        }else{
            return false;
        }
    }

    public char Win_char(){
        for (int i=0; i<3; i++){
            if (board[i][2]==board[i][1] && board[i][2]==board[i][0])
                return board[i][0];
        }
        for (int i=0; i<3; i++){
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i])
                return board[0][i];
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return board[0][0];

        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return board[0][2];


        return ' ';
    }

    public void printBoard(){
        System.out.println("    |    |   ");
        System.out.println("  "+board[0][0]+" |  "+board[0][1]+" |  "+board[0][2]);
        System.out.println("-------------");
        System.out.println("    |    |   ");
        System.out.println("  "+board[1][0]+" |  "+board[1][1]+" |  "+board[1][2]);
        System.out.println("--------------");
        System.out.println("    |    |    ");
        System.out.println("  "+board[2][0]+" |  "+board[2][1]+" |  "+board[2][2]);
    }

    public char get_chance(int ch){
        if (ch % 2 ==1)
            return 'X';
        else
            return 'O';
    }


    Start() {
        System.out.println("First player will be the 'X' and second will be O");
        System.out.println("Position system: 1-9 1 will be first left corner and 2 will be middle 1st row and 3 will be right corner and 4 will be 2nd row and there goes..");
        int c=1;
        boolean win=false;
        while(c<=9){
            printBoard();
            System.out.println(get_chance(c)+" will go now enter position 1-9:");
            int p=in.nextInt();
            if (insert(p,get_chance(c))){
                char wc=Win_char();
                if (wc!=' '){
                    printBoard();
                    System.out.println("Game ends");
                    System.out.println("Hurray!!!!!!!!! "+wc+" wins");
                    win=true;
                    break;
                }else{
                    c++;
                }
            }else{
                System.out.println("The position may be invalid or already filled try again");
            }
        }
        System.out.println((!win)?"Game Over! It ends with a draw":"");
    }
}
