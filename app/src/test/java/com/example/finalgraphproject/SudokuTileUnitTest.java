package com.example.finalgraphproject;

import org.junit.Test;

public class SudokuTileUnitTest extends SudokuTile{
    @Test
    public void construct() {
        SudokuTile t = new SudokuTile();
    }

    @Test
    public void setValues() {
        SudokuTile t = new SudokuTile();
        t.setNumber(7);
        assert (t.getNumber()==7);
    }

    @Test
    public void testVisitStatus() {
        SudokuTile t = new SudokuTile();
        t.setNumber(7);
        t.setVisited();
        assert (t.isVisited());
        t.resetVisited();
        assert (!t.isVisited());
    }
}
