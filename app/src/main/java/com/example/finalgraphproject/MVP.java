package com.example.finalgraphproject;

public interface MVP {
    public interface ViewPresenter {
        void DisplayTable();
        Integer[][] getTable();
    }


    public interface Model {
        SudokuTable makeSudokuTable(Integer[][] table);
        boolean solveTable(SudokuTable table);
        Integer[][] makeArray(SudokuTable t);
    }
}
