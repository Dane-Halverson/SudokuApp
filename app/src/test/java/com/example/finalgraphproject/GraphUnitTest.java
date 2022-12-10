package com.example.finalgraphproject;

import org.junit.Test;

public class GraphUnitTest {

    @Test
    void testGraphCreation() {
        Graph g = new SudokuGraph();
    }
    @Test
    void addVertices() {
        //add vertex
        Graph g = new SudokuGraph();
        Vertex v = new Vertex();
        g.addVertex(v);

        int num = g.getVerticesCount();
        assert (num == 1);
    }
    @Test
    void addEdges() {

        Graph g = new SudokuGraph();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        g.addVertex(v1);

        g.addVertex(v2);
        Edge e = new Edge(v1, v2);
        Edge e2 = new Edge(v2, v1);
        g.addEdge(e);
        g.addEdge(e2);

    }



}
