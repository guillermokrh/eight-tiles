/**
 * Created by guillermo on 11/5/16.
 */


import java.util.*;
public class TilesDriver {

    private Board gameBoard;
    private Board bestBoard;
    private boolean isSolved;
    private int numberOfMoves;

    //Empty constructor for the board
    public TilesDriver(){
        //do not initialize tiles driver board yet
        //gameBoard = new Board();
        isSolved = false;
    }

    public static void main(String[] args){
        TilesDriver newGame = new TilesDriver();
        newGame.printAuthorInformation();
        newGame.printGameInformation();
        newGame.chooseGameBoardOption();

        System.out.println("Initial board is: ");
        newGame.gameBoard.printBoard();
        newGame.playGame();
    }

    public void playGame(){
        numberOfMoves = 0; //initialize number of moves to 0

        char userChoice;
        int numberToMove;
        int posOfNumberToMove;
        int posOfEmptySpace;
        Scanner userInput = new Scanner(System.in);


        while (true) {
            userChoice = userInput.next().charAt(0);
            posOfEmptySpace = gameBoard.getPositionOfNumber(0);

            if (userChoice == 'x') {
                System.out.println("Exiting Program");
                return; //finish game
            } else if (userChoice == 's'){
                System.out.println("Solving Automatically... Placeholder");
                return;
            }

            numberToMove = Character.getNumericValue(userChoice);
            System.out.println("user choice: " + numberToMove);
            posOfNumberToMove = gameBoard.getPositionOfNumber(numberToMove);
            System.out.println("position of user choice: " + posOfNumberToMove);
            if (gameBoard.isPossibleMove(posOfNumberToMove) == true){
                System.out.println("Move is possible.");
            } else {
                System.out.println("Move is not possible.");
            }
            //otherwise, we know we are not dealing with x or s

        }

    }

    public void printAuthorInformation(){
        System.out.println("Author: Guillermo Rojas Hernandez");
        System.out.println("Class: CS 342, Fall 2016");
        System.out.println("Program: #3, 8 Tiles");
        System.out.println();
    }

    public void printGameInformation(){
        System.out.println("Welcome to the 8-tiles puzzle.");
        System.out.println("Place the tiles in ascending numerical order.  For each move");
        System.out.println("enter the piece to be moved into the blank square, or 0 to exit the program.");
        System.out.println();
    }

    public void chooseGameBoardOption(){
        System.out.println("Choose a game option:");
        System.out.println("1. Start Playing");
        System.out.println("2. Set the starting configuration");
        System.out.print("Enter your choice --> ");

        //get user input for starting configuration
        Scanner userInput = new Scanner(System.in);
        int userChoice = userInput.nextInt();

        System.out.print("You chose: " + userChoice);
        System.out.println();

        if (userChoice == 1){
            randomizeBoard();
        } else if (userChoice == 2){
            setUserConfiguration();
        } else {
            System.out.println();
            System.out.println("Error! You must choose options 1 or 2.");
            System.out.println();
            chooseGameBoardOption();
        }
    }

    public void randomizeBoard(){
        System.out.println("You chose to randomize the board!");
        gameBoard = new Board();
    }

    public void setUserConfiguration(){
        System.out.println("You chose to set the user configuration!");
        System.out.println("Some boards such as 728045163 are impossible.");
        System.out.println("Others such as 245386107 are possible.") ;
        System.out.print("Enter a string of 9 digits (including 0) for the board -->  ");
        Scanner userInput = new Scanner(System.in);
        String userBoard = userInput.nextLine();
        gameBoard = new Board(userBoard);
    }

    /*Getter Functions*/
    public Board getGameBoard() {
        return gameBoard;
    }

    public Board getBestBoard() {
        return bestBoard;
    }

    public boolean isSolved() {
        return isSolved;
    }

    /*Setter Functions*/
    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setBestBoard(Board bestBoard) {
        this.bestBoard = bestBoard;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }


}
