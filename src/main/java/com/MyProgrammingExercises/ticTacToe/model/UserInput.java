package com.MyProgrammingExercises.ticTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserInput {
    private String inputValue;
    private int position;
    private boolean editable;

    public UserInput(int position,boolean editable){
        this.position = position;
        this.editable = editable;
    }
}
