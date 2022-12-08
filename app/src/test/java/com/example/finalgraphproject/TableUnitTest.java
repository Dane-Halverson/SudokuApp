package com.example.finalgraphproject;

import org.junit.Test;

public class TableUnitTest extends SudokuTable {
    @Test
    public void constructTable() {
        SudokuTable t = new SudokuTable();
    }

    @Test
    public void tableSetsValues() {
        SudokuTable t = new SudokuTable();
        t.set(5, 0, 0);
        assert (t.get(0, 0).getNumber() == 5);

        t.set(7, 8, 8);
        assert (t.get(8, 8).getNumber() == 7);
    }

    @Test
    public void tablePrintsValues() {
        SudokuTable t = new SudokuTable();
        t.set(5, 0, 0);
        t.set(2, 4, 6);
        t.set(9, 8, 7);
        t.printTable();
    }


}
