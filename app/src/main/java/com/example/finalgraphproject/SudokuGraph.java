package com.example.finalgraphproject;


import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class SudokuGraph extends Graph implements Serializable {

    private final Integer TILE_COUNT = 81;

    SudokuGraph() {
        super();
    }

    public void addAllRelations(LinkedList<SudokuRelation> l) {
        for (SudokuRelation r: l) {
            addEdge(r);
        }
    }
    public void printGraph() {
        System.out.println("Graph: ");
        for (HashMap.Entry<VertexInterface, LinkedList<EdgeInterface>> hEntry : edges.entrySet()) {
            System.out.print(hEntry.getKey().getNumber() + " --> ");
            for (int i = 0; i < hEntry.getValue().size(); ++i) {
                System.out.print(" { " + hEntry.getValue().get(i).getDst().getNumber() + " } --> ");
            }
            System.out.println("null");
        }
    }

    public Integer getTileCount() {return TILE_COUNT;}

}
