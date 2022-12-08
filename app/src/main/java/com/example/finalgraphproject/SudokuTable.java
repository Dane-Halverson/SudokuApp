package com.example.finalgraphproject;

import java.io.Serializable;

public class SudokuTable implements Serializable {

    private final SudokuTile[][] table;

    /**
     * class that holds a 2D array of sudoku tiles.
     * accessible by row/col idx
     */
    public SudokuTable() {
        table = new SudokuTile[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                table[i][j] = new SudokuTile();
            }
        }
    }


    /**
     * @param value value to set
     * @param row 0-8
     * @param column 0-8
     */
    public void set(Integer value, Integer row, Integer column) {
        table[row][column].setNumber(value);
    }

    /**
     * @param row 0-8
     * @param column 0-8
     * @return the tile object in that space
     */
    public SudokuTile get(Integer row, Integer column) {
        return table[row][column];
    }

    /**
     * prints the table to terminal
     * null values will print as 0
     */
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
