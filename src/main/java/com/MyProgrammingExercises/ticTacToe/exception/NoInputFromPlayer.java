package com.MyProgrammingExercises.ticTacToe.exception;

import javax.swing.*;
/*
Reference: https://www.baeldung.com/java-new-custom-exception
This is a custom, unchecked exception
 */
public class NoInputFromPlayer extends RuntimeException{
    public NoInputFromPlayer(JLabel displayMsg) {
        displayMsg.setText("Please enter one input");
    }
}
