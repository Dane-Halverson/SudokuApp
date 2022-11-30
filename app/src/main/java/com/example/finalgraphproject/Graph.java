package com.example.finalgraphproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph{
    final HashMap<Vertex, LinkedList<Edge>> edges;

    /**
     * constructor for graph
     */
    public Graph() {
        edges = new HashMap<>(2048);
    }

    /**
     * @param s the name of the vertex to add
     */
    void addVertex(Vertex v) {
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
    public void addEdge(Edge e) {

        edges.get(e.getSrc()).add(e);

        //edges.get(v2).add(v1);

    }

    /**
     * @return the amount of edges
     */
    public int getEdgeCount() {
        int edgeSum = 0;

        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : edges.entrySet()) {
            edgeSum = edgeSum + hEntry.getValue().size();
        }
        return edgeSum;
    }

    /**
     * prints the graph showing the relations
     */
    public void printGraph() {
        System.out.println("Graph: ");
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : edges.entrySet()) {
            System.out.print(hEntry.getKey().getLabel() + " --> ");
            for (int i = 0; i < hEntry.getValue().size(); ++i) {
                System.out.print(" { " + hEntry.getValue().get(i).getDst().getLabel() + " } --> ");
            }
            System.out.println("null");
        }
    }

    /**
     * @param vertex the vertex to get the out degree of
     * @return the out degree
     */
    public int outDegree(Vertex v) {
        return edges.get(v).size();
    }

    /**
     * @param vertex the vertex to get the in degree of
     * @return the in degree
     */
    public int inDegree(Vertex v) {
        int out = 0;
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : edges.entrySet()) {
            for (int i = 0; i < hEntry.getValue().size(); ++i) {
                if (hEntry.getValue().get(i).getDst().getLabel() == v.getLabel()) {
                    ++out;
                }
            }
        }
        return out;
    }

    /**
     * resets all vertices to not visited
     */
    public void resetVertexStatus() {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : edges.entrySet()) {
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
    public LinkedList<Vertex> getNeighbors(Vertex v) {
        HashSet<Vertex> s = new HashSet<>();
        for (Edge e: edges.get(v)) {
            s.add(e.getDst());
        }
        return null;
    }

    /**
     * @return a list of all vertices
     */
    public LinkedList<Vertex> getAllVertices() {
        LinkedList<Vertex> l = new LinkedList<>();
        Set<Vertex> s = edges.keySet();
        l.addAll(s);

        return l;
    }
}
