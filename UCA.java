package tictactae;

import java.util.Scanner;
public class UCA {

       static char[] board = new char[10]; // create char array of size 10
       static char userLetter;
       static char computerLetter;

    public static void main(String[] args) {
        createEmptyBoard();
        chooseLetter();
     while(true) {
          playerTurn();
          computerTurn();
         chooseLetter();
         showBoard();
         checkFreeSpace();
         winner();
     }
     }
 //uc1
    private static void createEmptyBoard(){
    for(int index = 1;  index < board.length ; index++){  // array index  from 1 to 9 for loop
     board[index] =' ';
    }
    }
    //uc2
    private static void chooseLetter(){
        Scanner sc =new Scanner(System.in);
        System.out.println("choose a letter :: X or O : ");
        userLetter =sc.next().toUpperCase().charAt(0);
        computerLetter =(userLetter == 'x') ? 'O' : 'X'; // ternary operator
    }

    //uc3
    private static void showBoard()
    {
        System.out.println(board[1] + "||"  +board[2] +"||" +board[3]);
        System.out.println(board[4] +"||"  +board[5] +"||" +board[6]);
        System.out.println(board[7] + "||" +board[8] +"||" +board[9]);
    }

    //uc4

    private static void  playerTurn(){
        int playerMove;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose your location(1-9): ");
            playerMove = scanner.nextInt();
            if(board[playerMove]==' '){
                break;
            }
        }
        System.out.println("player choose:: " + playerMove);
        board[playerMove]= userLetter;
    }

    //uc5
    private static void checkFreeSpace(){
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces =0;
        for(int index=1;index<board.length;index++)
        {
            if((board[index] == ' '))
            {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if(isSpaceAvailable == false)
        {
            System.err.println("Board is full! You can't make another move");
            System.exit(0);
        }
        else
        {
            System.out.println("Free space is available! you have "+numOfFreeSpaces+ " moves left");
        }
    }


    //uc6
    private static void checkFirstPlayer()
    {
        int Head = 0;
        double toss = Math.floor(Math.random()*10) % 2;
        if ( toss == Head )
        {
            System.out.println("computer starts to play first");
        }
        else
        {
            System.out.println("User starts to play first");
        }
    }
 //uc7
 private static void winner()
 {
     if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) ||
             (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter) ||
             (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter) ||
             (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter) ||
             (board[3] == userLetter && board[5] == userLetter && board[7] == userLetter))
     {
         showBoard();
         System.out.println("Player win the game");
         System.exit(0);
     }
 }
 //uc8
 private static void computerTurn()
 {
     int computerMove;
     while (true)
     {
         computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
         if (board[computerMove] == ' ')
         {
             break;
         }

     }
     System.out.println("Computer choose:: " + computerMove);
     board[computerMove] = computerLetter;
 }
}

