/**
 * Created by guillermo on 11/5/16.
 */
import java.util.*;
import java.lang.*; //imports java math methods
//import static Constants.*;
public class Board {

    private int[] board;
    private int heuristicValue;
    //private int BOARDSIZE;

    //default board involves board randomization
    public Board(){
        //BOARDSIZE = 9;
        board = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        initializeRandomBoard();
        heuristicValue = calculateHeuristicValue();
    }

    //custom board
    public Board(String input){
        //BOARDSIZE = 9;
        board = new int[Constants.BOARD_SIZE];
        initializeCustomBoard(input);
        heuristicValue = calculateHeuristicValue();
    }

    //initialize with random values
    public void initializeCustomBoard(String input){

        char currChar;
        for (int i = 0; i < Constants.BOARD_SIZE; i++){
            currChar = input.charAt(i);
            board[i] = Character.getNumericValue(currChar);
        }

        //'printBoard();
    }

    public void initializeRandomBoard(){

        System.out.println();
        Random generateRandom = new Random();
        generateRandom.setSeed(System.currentTimeMillis());

        int boardIndex = -1;
        for (int i = 0; i < Constants.BOARD_SIZE; i++){
            boardIndex = generateRandom.nextInt(Constants.BOARD_SIZE);
            while (board[boardIndex] != -1){
                boardIndex = generateRandom.nextInt(Constants.BOARD_SIZE);
                //System.out.println("Board index: " + boardIndex);
            }
            board[boardIndex] = i; //once the index at the board is -1, set the number
        }

        //printBoard();
    }

    public int calculateHeuristicValue(){
        int currentValue;
        int currentRow;
        int currentCol;
        int finalRow;
        int finalCol;
        int heuristicAccumulation = 0;
        for (int i = 0; i < Constants.BOARD_SIZE; i++){

            currentValue = board[i];
            currentRow = i/3; //rows 0-2
            currentCol = i%3; //cols 0-2
            finalRow = Constants.FINISHED_STATE[currentValue][0];
            finalCol = Constants.FINISHED_STATE[currentValue][1];

            /*
            System.out.println("Value: " + currentValue + " Row: " + currentRow +" Col: " + currentCol);
            System.out.println("Ideal final row: " + Constants.FINISHED_STATE[currentValue][0]);
            System.out.println("Ideal final column: " + Constants.FINISHED_STATE[currentValue][1]);
            */

            heuristicAccumulation = heuristicAccumulation + Math.abs(currentRow-finalRow) + Math.abs(currentCol-finalCol);
        }
        //System.out.println("Heuristic value: " + heuristicAccumulation);
        return heuristicAccumulation;
    }

    public int[] getBoard() {
        return board;
    }

    public int getHeuristicValue() {
        return heuristicValue;
    }

    public int getPositionOfNumber(int value) {
        //return BOARDSIZE;
        for (int i = 0; i < Constants.BOARD_SIZE; i++){
            if (board[i] == value){
                return i;
            }
        }
        return -1; //if value not found, returns a negative 1
    }

    /*
    1 2 3  [[2,2], [0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1]]
    4 5 6
    7 8 0
     */
    public boolean isPossibleMove(int index){
        int currentEmptySpace = this.getPositionOfNumber(0);
        for (int i = 0; i < Constants.POSSIBLE_MOVES[currentEmptySpace].length; i++){
            if (Constants.POSSIBLE_MOVES[currentEmptySpace][i] == index){
                return true;
            }
        }
        return false;
    }

    public int findRowDistance(){
        return 0;
    }

    public int findColumnDistance(){
        return 0;
    }

    @Override
    public String toString(){
        String boardString = "";
        for (int i = 0; i < Constants.BOARD_SIZE; i++){
            if (board[i] == 0){ //if the space is occupied by a 0
                boardString = boardString + " " + " "; //do not print the board number, print a space
            } else {
                boardString = boardString + board[i] + " ";
            }

            if(i % 3 == 2){
                boardString = boardString + "\n";
            }
        }
        return boardString;
    }

    public void printBoard(){
        System.out.println(toString());
    }

}
