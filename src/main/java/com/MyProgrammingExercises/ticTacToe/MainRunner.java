package com.MyProgrammingExercises.ticTacToe;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
/*
Flow:
1.
 */
public class MainRunner {

    @Autowired
    static UtilMethods utilMethods;

    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        utilMethods.displayMethod(myBoard);
    }
}
