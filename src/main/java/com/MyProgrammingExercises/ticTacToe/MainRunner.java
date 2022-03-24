package com.MyProgrammingExercises.ticTacToe;

import javax.swing.*;

public class MainRunner {
    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        myBoard.setContentPane(myBoard.getMainPanel());
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }
}
