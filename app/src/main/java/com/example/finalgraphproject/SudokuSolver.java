package com.example.finalgraphproject;

import java.util.LinkedList;
import java.util.Objects;

public class SudokuSolver {

    SudokuSolver() {

    }

    /**
     * @param t table to solve
     */
    public void solve(SudokuTable t) {
        SudokuGraphBuilder b = new SudokuGraphBuilder();
        SudokuGraph g = b.buildGraph(t);
        g.resetVertexStatus();
        if (!DFSolve(g, t.get(0, 0), 1)) {
            g.resetVertexStatus();
            throw new RuntimeException("Table not solvable");
        }
        g.resetVertexStatus();


    }



    protected Boolean DFSolve(SudokuGraph g, SudokuTile s, int idx) {
            s.setVisited();
            //System.out.println("Visited vertex: " + s.getNumber());

            // get the list of edges (and vertices) of v
            LinkedList<VertexInterface> neighborList = g.getNeighbors(s);

            if(!s.isStartTile()) {
                for (int i = 1; i <= 9; ++i) {

                    if (isSafe(g, s, i)) {
                        s.setNumber(i);
                        if (idx == 81) {
                            return true;
                        }
                        boolean allValid = true;
                        for (int edgeIdx = 0; edgeIdx < neighborList.size(); edgeIdx++) {
                        // if we have not visited this vertex
                            if (!neighborList.get(edgeIdx).isVisited()) {
                                Boolean childValid = DFSolve(g, (SudokuTile) neighborList.get(edgeIdx), idx + 1);

                                if(!childValid) {
                                    allValid = false;
                                    break;
                                }
                            }
                        }
                        if (allValid) {
                            return true;
                        }
                    }
                }
            }
            //if start tile
            else {
                if (idx == 81) {
                    return true;
                }
                if (!isValid(g, s)) {
                    return false;
                }
                boolean allValid = true;
                for (int edgeIdx = 0; edgeIdx < neighborList.size(); edgeIdx++) {

                    if (!neighborList.get(edgeIdx).isVisited()) {
                        Boolean childValid = DFSolve(g, (SudokuTile) neighborList.get(edgeIdx), idx + 1);
                        if (!childValid) {
                            allValid = false;
                            break;
                        }
                    }
                }
                if (allValid) {
                    return true;
                }
            }
            if (!s.isStartTile())
                s.setNumber(null);
            s.resetVisited();
            return false;


    }

    protected Boolean isValid(SudokuGraph g, SudokuTile t) {
        LinkedList<VertexInterface> l = g.getNeighbors(t);
        for (VertexInterface i: l) {
            if (i.getNumber() == t.getNumber() && i.isStartTile() && t.isStartTile()) {

                throw new RuntimeException("Table Not Solvable");
            }
            if (i.getNumber() == t.getNumber()) {
                return false;
            }
        }
        return true;
    }

    protected Boolean isSafe(SudokuGraph g, SudokuTile t, Integer i) {
        LinkedList<VertexInterface> l = g.getNeighbors(t);
        for (VertexInterface v : l) {
            if (Objects.equals(v.getNumber(), i)) {
                return false;
            }
        }
        return true;
    }

}
