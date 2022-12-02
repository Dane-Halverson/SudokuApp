package com.example.finalgraphproject;

import java.io.Serializable;

public class SudokuTable implements Serializable {

    private SudokuTile[][] table;

    public SudokuTable() {
        table = new SudokuTile[8][8];


    }

    public void set(Integer value, Integer row, Integer column) {
        table[row][column].setNumber(value);
    }

    public SudokuTile get(Integer row, Integer column) {
        return table[row][column];
    }

}
