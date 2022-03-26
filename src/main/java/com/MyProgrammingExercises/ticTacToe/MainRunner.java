package com.MyProgrammingExercises.ticTacToe;

import com.MyProgrammingExercises.ticTacToe.exception.MoreThanOneInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.NoInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.WrongInputFormat;
import com.MyProgrammingExercises.ticTacToe.service.UtilMethods;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Flow:
1. Display page using displayMethod(myBoard)
2. Click submit --> call playerClickedSubmit method
3. playerClickedSubmit
--> update2DArray
--> check number of inputs (0,1,more)
--> check input format
 */

public class MainRunner {

    static int playerTurnCount = 0;

    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        UtilMethods.displayMethod(myBoard);

        /*
        Call util method playerClickedSubmit when player clicks submit button
         */
        myBoard.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    playerTurnCount+=1;
                    UtilMethods.playerClickedSubmit(myBoard, playerTurnCount);
                }catch(NoInputFromPlayer noInputFromPlayerException){
                    // logging
                }catch(MoreThanOneInputFromPlayer moreThanOneInputFromPlayerException){
                    // logging
                }catch(WrongInputFormat wrongInputFormatException){
                    // logging
                }

            }
        });

        /*
        Reset the board: clear all values & set editable to true
         */
        myBoard.getResetBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTurnCount=0;
                UtilMethods.playerClickedReset(myBoard);
                UtilMethods.displayMethod(myBoard);
            }
        });
    }

}
