package com.example.finalgraphproject;

public class SudokuPresenter implements MVP.Model{

    MVP.ViewPresenter presenter;

    SudokuPresenter(MVP.ViewPresenter p) {
        presenter = p;
    }

    SudokuSolver sudokuSolver = new SudokuSolver();
    @Override
    public boolean solveTable(SudokuTable table) {

        try {
            sudokuSolver.solve(table);
        }
        catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Override
    public SudokuTable makeSudokuTable(Integer[][] table) {
        SudokuTable t = new SudokuTable();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (table[i][j] != null)
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
