package com.MyProgrammingExercises.ticTacToe;

import javax.swing.*;

/*
Reference Source for implementation idea: https://www.geeksforgeeks.org/tic-tac-toe-game-in-java/
Plan: User to input X or O in GUI
Necessary checks:
- only one input allowed
- depending on the turn, input should be X or O (use playerTurn label to display which player's turn)
- if either one condition is not met, display message to be shown (use displayMsg label)
Use a 2D array to track the input
If there is a match of 3, show success. If all 9 boxes are filled, show No Win
- hide playerTurn label
- use displayMsg
- clear board
 */

public class TicTacToeBoard extends JFrame{
    private JTextField textField1;
    private JPanel mainPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton submit;
    private JLabel playerTurn;
    private JLabel displayErrMsg;

    public static void main(String[] args) {

        TicTacToeBoard myBoard = new TicTacToeBoard();
        myBoard.setContentPane(myBoard.mainPanel);
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }
}
