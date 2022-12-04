package com.example.finalgraphproject;

import java.util.LinkedList;

public class SudokuGraphBuilder {

    public SudokuGraphBuilder() {

    }

    public SudokuGraph buildGraph(SudokuTable t) {
        SudokuGraph g = new SudokuGraph();

        for (int i = 0; i <= 8; ++i) {
            for (int j = 0; j <= 8; ++j) {
                g.addVertex(t.get(i, j));
                if (t.get(i, j).getNumber() != null) {
                    t.get(i, j).setIfStartTile(true);
                }
            }
        }

        getRelations(g, t);
        return  g;
    }

    private void getRelations(SudokuGraph g, SudokuTable t) {

        for (int srcR = 0; srcR <= 8; ++srcR) {
            for (int srcC = 0; srcC <= 8; ++srcC) {

                //columns
                for ( int dstR = 0; dstR <= 8; ++dstR) {
                    if (dstR != srcR)
                        //System.out.println("added");
                        g.addEdge(new SudokuRelation(t.get(srcR, srcC),  t.get(dstR, srcC)));
                }
                //rows
                for ( int dstC = 0; dstC <= 8; ++dstC) {
                    if (dstC != srcC)
                        g.addEdge(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR, dstC)));
                }
                //boxes
                getBoxRelations(g, t, srcR, srcC);
            }
        }

    }

    private void getBoxRelations(SudokuGraph g, SudokuTable t, int srcR, int srcC) {


        for (int i = srcR/3 * 3; i <( srcR/3 *3) + 3; ++i) {
            for (int j = srcC/3 *3; j < (srcC/3*3) +3; ++j) {
                if (!g.getNeighbors(t.get(srcR, srcC)).contains(t.get(i, j)) && t.get(srcR, srcC) != t.get(i, j)) {
                    g.addEdge(new SudokuRelation(t.get(srcR, srcC), t.get(i, j)));
                }
            }
        }



    }


}
