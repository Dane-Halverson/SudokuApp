package com.example.finalgraphproject;

public class SudokuModel implements MVP.Model{
    SudokuSolver sudokuSolver;
    @Override
    public boolean solveTable(SudokuTable table) {

        try {
            sudokuSolver.solve(table);
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public SudokuTable makeSudokuTable(Integer[][] table) {
        SudokuTable t = new SudokuTable();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                t.set(table[i][j], i, j);
            }
        }
        return t;
    }

    @Override
    public Integer[][] makeArray(SudokuTable t) {
        Integer[][] table = new Integer[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                table[i][j] = t.get(i, j).getNumber();
            }
        }
        return table;
    }


}
