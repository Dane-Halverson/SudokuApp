package com.example.finalgraphproject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap; // import the HashMap class
import java.util.Set;


public abstract class Graph implements Serializable {
    private final HashMap<VertexInterface, LinkedList<EdgeInterface>> edges;

    /**
     * constructor for graph
     */
    public Graph() {
        edges = new HashMap<>(2048);
    }

    /**
     * @param s the name of the vertex to add
     */
    public void addVertex(VertexInterface v) {
        //every time you add a vertex, you add another linked list ro represent the edges
        edges.putIfAbsent(v, new LinkedList<>());
    }

    /**
     * @return the number of vertices added
     */
    public int getVerticesCount() {
        return  edges.size();
    }


    /**
     * @param src source edge
     * @param dst destination edge
     */
    public void addEdge(EdgeInterface e) {

        edges.get(e.getSrc()).add(e);

        //edges.get(v2).add(v1);

    }

    /**
     * @return the amount of edges
     */
    public int getEdgeCount() {
        int edgeSum = 0;

        for (HashMap.Entry<VertexInterface, LinkedList<EdgeInterface>> hEntry : edges.entrySet()) {
            edgeSum = edgeSum + hEntry.getValue().size();
        }
        return edgeSum;
    }


    /**
     * resets all vertices to not visited
     */
    public void resetVertexStatus() {
        for (HashMap.Entry<VertexInterface, LinkedList<EdgeInterface>> hEntry : edges.entrySet()) {
            hEntry.getKey().resetVisited();
            for (int i = 0; i < hEntry.getValue().size(); ++i) {
                hEntry.getValue().get(i).getDst().resetVisited();
            }
        }
    }


    /**
     * @param v the vertex to get
     * @return a list of neighbor vertices to the vertex
     */
    public LinkedList<Vertex> getNeighbors(VertexInterface v) {
        HashSet<VertexInterface> s = new HashSet<>();
        for (EdgeInterface e: edges.get(v)) {
            s.add(e.getDst());
        }
        return null;
    }

    /**
     * @return a list of all vertices
     */
    public LinkedList<VertexInterface> getAllVertices() {
        LinkedList<VertexInterface> l = new LinkedList<>();
        Set<VertexInterface> s = edges.keySet();
        l.addAll(s);

        return l;
    }
}
