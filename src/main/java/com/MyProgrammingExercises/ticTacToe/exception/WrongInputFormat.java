package com.MyProgrammingExercises.ticTacToe.exception;

import javax.swing.*;

public class WrongInputFormat extends RuntimeException{
    public WrongInputFormat(JLabel displayMsg) {
        displayMsg.setText("You have provided the wrong format. Please enter X or O");
    }
}
