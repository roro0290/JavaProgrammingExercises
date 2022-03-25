package com.MyProgrammingExercises.ticTacToe.service;

import com.MyProgrammingExercises.ticTacToe.TicTacToeBoard;
import com.MyProgrammingExercises.ticTacToe.model.UserInput;
import org.springframework.stereotype.Service;

@Service
public class BoardTableMapper {

    /*
    This method is used to create a board array
     */
    static UserInput[][]  create2DBoardArray(){
        UserInput[][] boardArray = new UserInput[3][3];
        // ROW 1
        boardArray[0][0] = new UserInput("",1,true);
        boardArray[0][1] = new UserInput("",2,true);
        boardArray[0][2] = new UserInput("",3,true);

        // ROW 2
        boardArray[1][0] = new UserInput("",4,true);
        boardArray[1][1] = new UserInput("",5,true);
        boardArray[1][2] = new UserInput("",6,true);

        // ROW 3
        boardArray[2][0] = new UserInput("",7,true);
        boardArray[2][1] = new UserInput("",8,true);
        boardArray[2][2] = new UserInput("",9,true);

        return boardArray;
    }

    /*
    This method is used to map the board to the 2DBoardArray
    Each time user clicks submit, the value they send will be updated in the board array
     */
    static UserInput[][] mapBoardToBoardArray(TicTacToeBoard board, UserInput[][] boardArray){
        // ROW 1
        boardArray[0][0].setInputValue(board.getTextField1().getText());
        boardArray[0][1].setInputValue(board.getTextField2().getText());
        boardArray[0][2].setInputValue(board.getTextField3().getText());

        // ROW 2
        boardArray[1][0].setInputValue(board.getTextField4().getText());
        boardArray[1][1].setInputValue(board.getTextField5().getText());
        boardArray[1][2].setInputValue(board.getTextField6().getText());

        // ROW 3
        boardArray[2][0].setInputValue(board.getTextField7().getText());
        boardArray[2][1].setInputValue(board.getTextField8().getText());
        boardArray[2][2].setInputValue(board.getTextField9().getText());

        return boardArray;
    }

    /*
    This method is used to map 2DBoardArray back to board
     */
    static void boardArrayToBoard(TicTacToeBoard board, UserInput[][] boardArray){
        // ROW 1
        board.getTextField1().setEditable(boardArray[0][0].isEditable());
        board.getTextField2().setEditable(boardArray[0][1].isEditable());
        board.getTextField3().setEditable(boardArray[0][2].isEditable());

        // ROW 2
        board.getTextField4().setEditable(boardArray[1][0].isEditable());
        board.getTextField5().setEditable(boardArray[1][1].isEditable());
        board.getTextField6().setEditable(boardArray[1][2].isEditable());

        // ROW 3
        board.getTextField7().setEditable(boardArray[2][0].isEditable());
        board.getTextField8().setEditable(boardArray[2][1].isEditable());
        board.getTextField9().setEditable(boardArray[2][2].isEditable());

    }

}
