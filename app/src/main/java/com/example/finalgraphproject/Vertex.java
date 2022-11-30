package com.example.finalgraphproject;

public class Vertex{
    private String vLabel;

    /**
     * default constructor
     * sets label to "Unassigned"
     */
    public Vertex() {
        vLabel = "Unassigned";
    }

    /**
     * @param label what to set the label to
     */
    public Vertex(String label) {
        this.vLabel = label;
    }

    private boolean visited = false;

    /**
     * @return the visited status
     */
    public boolean getVisited() {
        return visited;
    }

    /**
     * sets visited status to true
     */
    public void setVisited() {
        visited = true;
    }

    /**
     * sets visited status to false
     */
    public void resetVisited() {
        visited = false;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return vLabel;
    }

    private float distance = 0;

    /**
     * @param d what to set the distance to
     */
    public void setDistance(float d) {
        this.distance = d;
    }

    /**
     * @return the distance
     */
    public float getDistance() {
        return this.distance;
    }
}
