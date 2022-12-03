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

        LinkedList<SudokuRelation> r = getRelations(t);

        for (SudokuRelation i: r) {
            g.addEdge(i);
        }

        //g.addAllRelations(r);
        return  g;
    }

    private LinkedList<SudokuRelation> getRelations(SudokuTable t) {
        LinkedList<SudokuRelation> r = new LinkedList<>();

        for (int srcR = 0; srcR <= 8; ++srcR) {
            for (int srcC = 0; srcC <= 8; ++srcC) {

                //columns
                for ( int dstR = 0; dstR <= 8; ++dstR) {
                    if (dstR != srcR)
                        //System.out.println("added");
                        r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(dstR, srcC)));
                }
                //rows
                for ( int dstC = 0; dstC <= 8; ++dstC) {
                    if (dstC != srcC)
                        r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR, dstC)));
                }
                //boxes
                //getBoxRelations(t, srcR, srcC);

            }
        }



        return r;
    }

    private LinkedList<SudokuRelation> getBoxRelations(SudokuTable t, int srcR, int srcC) {
        LinkedList<SudokuRelation> r = new LinkedList<>();

        //top left
        if ((srcR % 3 == 0) && (srcC % 3 == 0)) {
            r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR+1, srcC+1)));
            r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR+2, srcC+1)));
            r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR+1, srcC+2)));
            r.add(new SudokuRelation(t.get(srcR, srcC),  t.get(srcR+2, srcC+2)));
        }
        //mid left
        else if ((srcR % 3 == 1) && (srcC % 3 == 0)) {

        }
        //bottom left
        else if ((srcR % 3 == 2) && (srcC % 3 == 0)) {

        }
        else if ((srcR % 3 == 0) && (srcC % 3 == 1)) {

        }
        else if ((srcR % 3 == 1) && (srcC % 3 == 1)) {

        }
        else if ((srcR % 3 == 2) && (srcC % 3 == 1)) {

        }
        else if ((srcR % 3 == 0) && (srcC % 3 == 2)) {

        }
        else if ((srcR % 3 == 1) && (srcC % 3 == 2)) {

        }
        else if ((srcR % 3 == 2) && (srcC % 3 == 2)) {

        }


        return r;
    }
}
