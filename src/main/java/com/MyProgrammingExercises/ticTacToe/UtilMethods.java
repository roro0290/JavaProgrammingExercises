package com.MyProgrammingExercises.ticTacToe;

import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class UtilMethods {

    public static void displayMethod(TicTacToeBoard myBoard){
        myBoard.setContentPane(myBoard.getMainPanel());
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }

}
