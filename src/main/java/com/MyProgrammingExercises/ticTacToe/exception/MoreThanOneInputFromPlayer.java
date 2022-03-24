package com.MyProgrammingExercises.ticTacToe.exception;

import javax.swing.*;

public class MoreThanOneInputFromPlayer extends RuntimeException{
    public MoreThanOneInputFromPlayer(JLabel displayMsg) {
        displayMsg.setText("You have provided more than one input. Please enter only one input");
    }
}
