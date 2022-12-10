package com.example.finalgraphproject;

import org.junit.Test;

public class SudokuEdgeUnitTest {
    @Test
    public void construction() {
        SudokuTile t1 = new SudokuTile();
        SudokuTile t2 = new SudokuTile();
        SudokuRelation r = new SudokuRelation(t1, t2);
    }

    @Test
    public void getSrcAndDst() {
        SudokuTile t1 = new SudokuTile();
        SudokuTile t2 = new SudokuTile();
        SudokuRelation r = new SudokuRelation(t1, t2);
    }
}
