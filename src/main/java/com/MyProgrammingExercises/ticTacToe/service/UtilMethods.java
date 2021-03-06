package com.MyProgrammingExercises.ticTacToe.service;

import com.MyProgrammingExercises.ticTacToe.TicTacToeBoard;
import com.MyProgrammingExercises.ticTacToe.exception.MoreThanOneInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.NoInputFromPlayer;
import com.MyProgrammingExercises.ticTacToe.exception.WrongInputFormat;
import com.MyProgrammingExercises.ticTacToe.model.UserInput;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class UtilMethods {

    static UserInput[][] boardArray;

    static int playerTurn = 0;

    public static void displayMethod(TicTacToeBoard myBoard){
        myBoard.setContentPane(myBoard.getMainPanel());
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }

    /*
    Check: Only one input allowed
    Filter variables that are not empty ("")
    Get the count of non-empty variables
    It will move to next method to check format only if there is one input else throw exception
    Valid input is sent to the next method
     */
    static UserInput checkNumOfInputFromPlayer(TicTacToeBoard myBoard, UserInput[][] boardArray) throws NoInputFromPlayer {
        int inputCount = 0;
        UserInput singleUserInput = new UserInput();
        for(UserInput[] row:boardArray){
            for(UserInput value:row){
                if(value!=null && value.isEditable()==true){
                    inputCount += value.getInputValue().equals("") ? 0 : 1;
                    if(!value.getInputValue().equals("")){
                        singleUserInput.setInputValue(value.getInputValue());
                        singleUserInput.setPosition(value.getPosition());
                    }
                }
            }
        }
        if(inputCount==0){
            throw new NoInputFromPlayer(myBoard.getDisplayMsg());
        }else if(inputCount>1){
            throw new MoreThanOneInputFromPlayer(myBoard.getDisplayMsg());
        }
        return singleUserInput;
    }

    /*
    Method to check that input format is either X or O (ignore case)
     */
    static void checkInputFormatIsCorrect(TicTacToeBoard myBoard, UserInput singleUserInput){
        boolean correctFormat = playerTurn%2==0 ? singleUserInput.getInputValue().equalsIgnoreCase("X") : singleUserInput.getInputValue().equalsIgnoreCase("O");
        if(!correctFormat){
            throw new WrongInputFormat(myBoard.getDisplayMsg());
        }
    }

    /*
    This method is called only after the input is validated
    Store the boardArray with this value and that input cannot be changed anymore
     */
    static UserInput[][] noEditsToValidInput(UserInput[][] boardArray,UserInput singleUserInput){
        switch (singleUserInput.getPosition()){
            case 1: {
                boardArray[0][0].setEditable(false);
                break;
            }
            case 2:{
                boardArray[0][1].setEditable(false);
                break;
            }
            case 3:{
                boardArray[0][2].setEditable(false);
                break;
            }
            case 4:{
                boardArray[1][0].setEditable(false);
                break;
            }
            case 5:{
                boardArray[1][1].setEditable(false);
                break;
            }
            case 6:{
                boardArray[1][2].setEditable(false);
                break;
            }
            case 7:{
                boardArray[2][0].setEditable(false);
                break;
            }
            case 8:{
                boardArray[2][1].setEditable(false);
                break;
            }
            case 9:{
                boardArray[2][2].setEditable(false);
                break;
            }
        }//end switch
        playerTurn+=1;
        return boardArray;
    }

    /*
    This method is called from the MainRunner when the player clicks submit
     */
    public static void playerClickedSubmit(TicTacToeBoard myBoard, int playerTurnCount){
        if(playerTurnCount==1){
            boardArray = BoardTableMapper.create2DBoardArray();
        }
        boardArray = BoardTableMapper.mapBoardToBoardArray(myBoard,boardArray);
        UserInput singleUserInput = checkNumOfInputFromPlayer(myBoard,boardArray);
        checkInputFormatIsCorrect(myBoard,singleUserInput);
        myBoard.getDisplayMsg().setText(""); // no error message
        if(playerTurn%2!=0){
            myBoard.getPlayerTurn().setText("Player 1, please input X");
        }else{
            myBoard.getPlayerTurn().setText("Player 2, please input O");
        }
        if(playerTurn>=4 && checkForWinner(boardArray)){
            if(playerTurn%2==0){
                myBoard.getPlayerTurn().setText("Player 1");
            }else{
                myBoard.getPlayerTurn().setText("Player 2");
            }
            myBoard.getDisplayMsg().setText("GAME WON");
        }else if(playerTurn==8){
            myBoard.getPlayerTurn().setText("");
            myBoard.getDisplayMsg().setText("NO WINNERS. PLEASE TRY AGAIN");
        }

        boardArray = noEditsToValidInput(boardArray, singleUserInput);
        BoardTableMapper.boardArrayToBoard(myBoard, boardArray);
    }

    public static TicTacToeBoard playerClickedReset(TicTacToeBoard myBoard){
        boardArray = new UserInput[3][3];
        BoardTableMapper.clearBoard(myBoard);
        myBoard.getDisplayMsg().setText("");
        myBoard.getPlayerTurn().setText("Player 1, please enter X");
        playerTurn = 0;
        return myBoard;
    }

    // return statement in each condition so that it does not continue evaluating
    static boolean checkForWinner(UserInput[][] boardArray){

        // check horizontal
        for(int i=0;i<3;i++){
            if(compareString(boardArray[i][0],boardArray[i][1])){
                if(compareString(boardArray[i][1],boardArray[i][2])){
                    return true;
                }
            }
        }

        // check vertical
        for(int i=0;i<3;i++){
            if(compareString(boardArray[0][i],boardArray[1][i])){
                if(compareString(boardArray[1][i],boardArray[2][i])){
                    return true;
                }
            }
        }

        //check diagonal
        if(compareString(boardArray[0][0],boardArray[1][1])){
            if(compareString(boardArray[1][1],boardArray[2][2])){
                return true;
            }
        }

        // check reverse diagonal
        if(compareString(boardArray[0][2],boardArray[1][1])){
            if(compareString(boardArray[1][1],boardArray[2][0])){
                return true;
            }
        }

        return false;
    }

    static boolean compareString(UserInput a, UserInput b){
        if(a.getInputValue().isEmpty()||b.getInputValue().isEmpty()){
            return false;
        }
        return a.getInputValue().equalsIgnoreCase(b.getInputValue());
    }
}
