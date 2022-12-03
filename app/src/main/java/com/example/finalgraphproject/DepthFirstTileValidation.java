package com.example.finalgraphproject;

import java.util.LinkedList;
import java.util.Objects;

public class DepthFirstTileValidation {

    public DepthFirstTileValidation() {

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

        if ((Objects.equals(v.getNumber(), firstTile.getNumber())) && v != firstTile)
            valid = false;

        if (valid) {
            LinkedList<VertexInterface> neighbors = g.getNeighbors(v);

            for (VertexInterface neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    neighbor.setVisited();
                    valid = traverse(g, (SudokuTile) neighbor, firstTile);
                }
            }
        }
        return valid;
    }
}
