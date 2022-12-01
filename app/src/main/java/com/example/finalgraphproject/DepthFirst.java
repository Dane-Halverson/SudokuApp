package com.example.finalgraphproject;

import java.util.LinkedList;

public class DepthFirst {
    public DepthFirst() {

    }
    public Boolean TraverseGraph(SudokuGraph g, SudokuTile v) {
        Boolean valid = traverse(g, v, v);
        g.resetVertexStatus();
        return valid;

    }
    private Boolean traverse(SudokuGraph g, SudokuTile v, SudokuTile firstTile) {
        Boolean valid = true;
        v.setVisited();
        //System.out.println("Vertex: " + v.getLabel());

        if ((v.getNumber() == firstTile.getNumber()) && v != firstTile)
            valid = false;

        if (valid) {
            LinkedList<SudokuTile> neighbors = g.getNeighbors(v);

            for (SudokuTile neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    neighbor.setVisited();
                    valid = traverse(g, neighbor, firstTile);
                }
            }
        }
        return valid;
    }
}
