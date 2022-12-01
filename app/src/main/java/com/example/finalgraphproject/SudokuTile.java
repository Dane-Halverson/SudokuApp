package com.example.finalgraphproject;

public class SudokuTile implements VertexInterface {

    SudokuTile(Boolean hasStarterNumber) {
        visited = false;
        startValue = hasStarterNumber;
    }

    private Integer number;

    private Boolean startValue;


    private boolean visited;

    public void resetVisited() {
        visited = false;
    }

    public void setVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean isStartTile() {
        return startValue;
    }

    public void setIfStartTile(Boolean startValue) {
        this.startValue = startValue;
    }
}
