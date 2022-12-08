package com.example.finalgraphproject;

public interface MVP {
    interface ViewPresenter {
        void DisplayTable();
        Integer[][] getTable();
    }


    interface Model {
        SudokuTable makeSudokuTable(Integer[][] table);
        boolean solveTable(SudokuTable table);
        Integer[][] makeArray(SudokuTable t);
    }
}
