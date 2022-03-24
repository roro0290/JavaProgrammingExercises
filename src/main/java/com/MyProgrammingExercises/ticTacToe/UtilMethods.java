package com.MyProgrammingExercises.ticTacToe;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Arrays;

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
     */
    static boolean checkInputFromUserIsOne(String[][] boardArray){
        int inputCount = 0;
        for(String[] row:boardArray){
            for(String value:row){
                inputCount += !value.equals("") ? 1 : 0;
            }
        }
        return inputCount==1;
    }

    static boolean checkInputFormatIsCorrect(String[][] boardArray){
        boolean correctFormat = false;
        for(String[] row:boardArray){
            for(String value:row){
                correctFormat = value.equalsIgnoreCase("X")
                        || value.equalsIgnoreCase("O");
                if(correctFormat){
                    break;
                }
            }
            if(correctFormat){
                break;
            }
        }
        return correctFormat;
    }

    public static void playerClickedSubmit(TicTacToeBoard myBoard,String[][] boardArray){
        update2DArray(myBoard,boardArray);
        boolean checkOneInput = checkInputFromUserIsOne(boardArray);
        if(checkOneInput){
            boolean inputFormat = checkInputFormatIsCorrect(boardArray);
            myBoard.getDisplayMsg().setText(String.valueOf(inputFormat));
        }else{
            myBoard.getDisplayMsg().setText("Please provide only one input");
        }
    }
}
