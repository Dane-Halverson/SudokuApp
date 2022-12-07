package com.example.finalgraphproject;

public class SudokuModel implements MVP.Model{
    SudokuSolver sudokuSolver;
    @Override
    public boolean solveTable(Integer[][] table) {
        SudokuTable t = new SudokuTable();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                t.set(table[i][j], i, j);
            }
        }

        try {
            sudokuSolver.solve(t);
        }
        catch (Exception e) {
            return false;
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                table[i][j] = t.get(i, j).getNumber();
            }
        }
        return true;

    }
}
