package com.example.finalgraphproject;


import java.io.Serializable;

public class SudokuTile extends Vertex implements Serializable {

    SudokuTile() {
        visited = false;
        startValue = false;
    }

    private Integer number;

    private Boolean startValue;


    private boolean visited;

    /**
     * sets visited to false
     */
    public void resetVisited() {
        visited = false;
    }

    /**
     * sets visited to true
     */
    public void setVisited() {
        visited = true;
    }

    /**
     * @return visited status
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @return the stored number.
     * null if value not set
    */
    @Override
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return if tile is a start tile or not
     */
    public Boolean isStartTile() {
        return startValue;
    }

    /**
     * @param startValue true of tile has a start value
     */
    public void setIfStartTile(Boolean startValue) {
        this.startValue = startValue;
    }
}
