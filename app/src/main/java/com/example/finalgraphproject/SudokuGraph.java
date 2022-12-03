package com.example.finalgraphproject;


import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class SudokuGraph extends Graph implements Serializable {


    SudokuGraph() {
        super();
    }

    public void addAllRelations(LinkedList<SudokuRelation> l) {
        for (SudokuRelation r: l) {
            addEdge(r);
        }
    }

}
