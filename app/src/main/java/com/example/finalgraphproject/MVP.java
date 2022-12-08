package com.example.finalgraphproject;

public interface MVP {

    interface ViewPresenter {
        /**
         * displays the table
         */
        void DisplayTable();

        /**
         * @return @d array of the Integers in the table
         */
        Integer[][] getTable();
    }


    interface Presenter {
        /**
         * @param table 2d array of Integers to convert
         * @return sudoku table object
         */
        SudokuTable makeSudokuTable(Integer[][] table);

        /**
         * @param table SudokuTable object to solve
         * @return true if able to solve
         */
        boolean solveTable(SudokuTable table);

        /**
         * @param t SudokuTable object to make into a 2D array
         * @return 2D array of integers
         */
        Integer[][] makeArray(SudokuTable t);
    }
}
