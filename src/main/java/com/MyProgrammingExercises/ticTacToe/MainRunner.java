package com.MyProgrammingExercises.ticTacToe;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Flow:
1. Display page using displayMethod(myBoard)
2. Click submit --> call update 2DArray method
 */
public class MainRunner {

    @Autowired
    static UtilMethods utilMethods;

    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        utilMethods.displayMethod(myBoard);

        String[][] board2DArray = new String[3][3];
        myBoard.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilMethods.update2DArray(myBoard,board2DArray);
                myBoard.getDisplayMsg().setText("clicked");
            }
        });
    }
}
