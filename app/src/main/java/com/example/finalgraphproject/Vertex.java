package com.example.finalgraphproject;


public class Vertex implements VertexInterface{
    private String vLabel;

    /**
     * default constructor
     * sets label to "Unassigned"
     */


    public Vertex() {
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

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public Integer getNumber() {
        return null;
    }


}


