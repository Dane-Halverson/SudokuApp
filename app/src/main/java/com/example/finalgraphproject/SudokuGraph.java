package com.example.finalgraphproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SudokuGraph {

    SudokuGraph(SudokuTable s) {
        mapTable = new HashMap<>();
    }

    HashMap<SudokuTile, LinkedList<SudokuRelation>> mapTable;

    public void addVertex(SudokuTile v) {
        mapTable.putIfAbsent(v, new LinkedList<>());
    }

    public int getVerticesCount() {
        return mapTable.size();
    }

    public void addEdge(SudokuRelation e) {
        mapTable.get(e.getSrc()).add(e);
    }

    public int getEdgeCount() {
        int edgeSum = 0;

        for (HashMap.Entry<SudokuTile, LinkedList<SudokuRelation>> hEntry : mapTable.entrySet()) {
            edgeSum = edgeSum + hEntry.getValue().size();
        }
        return edgeSum;
    }

    public void resetVertexStatus() {
        for (SudokuTile hEntry : mapTable.keySet()) {
                hEntry.resetVisited();
        }
    }

    public LinkedList<SudokuTile> getNeighbors(SudokuTile v) {
        HashSet<SudokuTile> s = new HashSet<>();
        for (SudokuRelation e: mapTable.get(v)) {
            s.add((SudokuTile) e.getDst());
        }
        LinkedList<SudokuTile> l = new LinkedList<>();
        l.addAll(s);
        return l;
    }

    public LinkedList<SudokuTile> getAllVertices() {
        LinkedList<SudokuTile> l = new LinkedList<>();

        l.addAll(mapTable.keySet());

        return l;
    }



}
