package com.example.finalgraphproject;

public class Edge implements EdgeInterface{

    private Vertex src;
    private Vertex dst;
    private float weight;
    final float DEFAULT_WEIGHT = 1.0f;


    /**
     * @param s the source vertex
     * @param d the destination vertex
     */
    public Edge(Vertex s, Vertex d) {
        weight = DEFAULT_WEIGHT;
        src = s;
        dst = d;
    }

    /**
     * @param s the source vertex
     * @param d the destination vertex
     * @param w the weight of the edge
     */
    public Edge(Vertex s, Vertex d, float w) {
        weight = w;
        src = s;
        dst = d;
    }

    /**
     * @param w what to set the weight to
     */
    public void setWeight(float w) {
        weight = w;
    }

    /**
     * @return the weight of the edge
     */
    public float getWeight() {
        return weight;
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
