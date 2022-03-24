package com.MyProgrammingExercises.ticTacToe;

import com.MyProgrammingExercises.ticTacToe.exception.MoreThanOneInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.NoInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.WrongInputFormat;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class UtilMethods {

    static int playerTurnCount = 0;

    public static void displayMethod(TicTacToeBoard myBoard){
        myBoard.setContentPane(myBoard.getMainPanel());
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }

    /*
    Input board and boardArray
    Fetch details from board
    Update the boardArray
    Check boardArray to see if it meets the conditions
     */
    static void update2DArray(TicTacToeBoard myBoard,String[][] boardArray){
        // ROW 1
        boardArray[0][0] = myBoard.getTextField1().getText();
        boardArray[0][1] = myBoard.getTextField2().getText();
        boardArray[0][2] = myBoard.getTextField3().getText();

        // ROW 2
        boardArray[1][0] = myBoard.getTextField4().getText();
        boardArray[1][1] = myBoard.getTextField5().getText();
        boardArray[1][2] = myBoard.getTextField6().getText();

        // ROW 3
        boardArray[2][0] = myBoard.getTextField7().getText();
        boardArray[2][1] = myBoard.getTextField8().getText();
        boardArray[2][2] = myBoard.getTextField9().getText();
    }

    /*
    Check: Only one input allowed
    Filter variables that are not empty ("")
    Get the count of non-empty variables
    It will move to next method to check format only if there is one input else throw exception
    Valid input is sent to the next method
     */
    static String checkNumOfInputFromPlayer(TicTacToeBoard myBoard, String[][] boardArray) throws NoInputFromPlayer {
        int inputCount = 0;
        String singleUserInput = "";
        for(String[] row:boardArray){
            for(String value:row){
                inputCount += !value.equals("") ? 1 : 0;
                if(!value.equals("")){
                    singleUserInput = value;
                }
            }
        }
        if(inputCount==0){
            throw new NoInputFromPlayer(myBoard.getDisplayMsg());
        }else if(inputCount>1){
            throw new MoreThanOneInputFromPlayer(myBoard.getDisplayMsg());
        }
        return singleUserInput;
    }

    /*
    Method to check that input format is either X or O (ignore case)
     */
    static void checkInputFormatIsCorrect(TicTacToeBoard myBoard, String singleUserInput){
        boolean correctFormat = singleUserInput.equalsIgnoreCase("X") || singleUserInput.equals("O");
        if(!correctFormat){
            throw new WrongInputFormat(myBoard.getDisplayMsg());
        }else{
            myBoard.getDisplayMsg().setText("next player");
        }
    }

    public static void playerClickedSubmit(TicTacToeBoard myBoard,String[][] boardArray){
        update2DArray(myBoard,boardArray);
        String singleUserInput = checkNumOfInputFromPlayer(myBoard,boardArray);
        checkInputFormatIsCorrect(myBoard,singleUserInput);
    }
}
