package com.MyProgrammingExercises.ticTacToe;

import com.MyProgrammingExercises.ticTacToe.exception.MoreThanOneInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.NoInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.WrongInputFormat;
import com.MyProgrammingExercises.ticTacToe.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
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

    @Autowired
    static UtilMethods utilMethods;

    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        utilMethods.displayMethod(myBoard);

        UserInput[][] board2DArray = new UserInput[3][3];
        myBoard.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    utilMethods.playerClickedSubmit(myBoard,board2DArray);
                }catch(NoInputFromPlayer noInputFromPlayerException){
                    // logging
                }catch(MoreThanOneInputFromPlayer moreThanOneInputFromPlayerException){
                    // logging
                }catch(WrongInputFormat wrongInputFormatException){
                    // logging
                }

            }
        });
    }
}
