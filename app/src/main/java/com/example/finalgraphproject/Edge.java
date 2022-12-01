package com.example.finalgraphproject;

/**
 * @class edge
 * a class to define an edge between two vertices
 */
public class Edge implements EdgeInterface{

    private Vertex src;
    private Vertex dst;



    /**
     * @param s the source vertex
     * @param d the destination vertex
     */
    public Edge(Vertex s, Vertex d) {
        src = s;
        dst = d;
    }




    /**
     * @return the source vertex
     */
    public Vertex getSrc() {
        return src;
    }

    /**
     * @return the destination vertex
     */
    public Vertex getDst() {
        return dst;
    }


}
