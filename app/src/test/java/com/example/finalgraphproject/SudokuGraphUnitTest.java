package com.example.finalgraphproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SudokuGraphUnitTest extends SudokuSolver {
    @Test
    public void createGraph() {
        SudokuGraphBuilder b = new SudokuGraphBuilder();
        SudokuTable t = new SudokuTable();
        SudokuTile tile = new SudokuTile();
        tile.setNumber(7);

        t.set(5, 0, 0);
        t.set(3, 0, 1);
        t.set(7, 0, 4);
        t.set(6, 1, 0);
        t.set(1, 1, 3);
        t.set(9, 1, 4);
        t.set(5, 1, 5);
        t.set(9, 2, 1);
        t.set(8, 2, 2);
        t.set(6, 2, 7);

        t.set(8, 3, 0);
        t.set(6, 3, 4);
        t.set(3, 3, 8);
        t.set(4, 4, 0);
        t.set(8, 4, 3);
        t.set(3, 4, 5);
        t.set(1, 4, 8);
        t.set(7, 5, 0);
        t.set(2, 5, 4);
        t.set(6, 5, 8);

        t.set(6, 6, 1);
        t.set(2, 6, 6);
        t.set(8, 6, 7);
        t.set(4, 7, 3);
        t.set(1, 7, 4);
        t.set(9, 7, 5);
        t.set(5, 7, 8);
        t.set(8, 8, 4);
        t.set(7, 8, 7);
        t.set(9, 8, 8);



        

        SudokuSolver sudokuSolver = new SudokuSolver();
        //assert(sudokuSolver.isValid(g, t.get(0, 0)));

        t.printTable();



        System.out.println();

        sudokuSolver.solve(t);

        t.printTable();





    }
}
