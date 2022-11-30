package com.example.finalgraphproject;

import java.io.Serializable;

public class SudokuTable implements Serializable {
    private Integer[][] table;

    public SudokuTable() {
        table = new Integer[8][8];

        for (Integer[] i: table) {
            for (Integer j: i) {
                j = -1;
            }
        }
    }

    public void set(Integer value, Integer row, Integer column) {
        table[row][column] = value;
    }

    public Integer get(Integer row, Integer column) {
        return table[row][column];
    }
}
