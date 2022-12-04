package com.example.finalgraphproject;

import java.io.Serializable;

public class SudokuTable implements Serializable {

    private SudokuTile[][] table;

    public SudokuTable() {
        table = new SudokuTile[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                table[i][j] = new SudokuTile();
            }
        }
    }


    public void set(Integer value, Integer row, Integer column) {

        table[row][column].setNumber(value);
    }

    public SudokuTile get(Integer row, Integer column) {
        return table[row][column];
    }

    public void printTable() {
        for (SudokuTile[] r: table) {
            for (SudokuTile t: r) {
                if (t.getNumber() == null) {
                    System.out.print(0 + " ");
                }
                else
                    System.out.print(t.getNumber() + " ");
            }
            System.out.println();
        }
    }

}
