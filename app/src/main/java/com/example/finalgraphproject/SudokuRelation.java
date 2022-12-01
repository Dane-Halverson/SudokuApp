package com.example.finalgraphproject;

public class SudokuRelation implements EdgeInterface {

    SudokuTile dst;
    SudokuTile src;

    SudokuRelation(SudokuTile s, SudokuTile d) {
        dst = d;
        src = s;
    }

    @Override
    public VertexInterface getDst() {
        return dst;
    }

    @Override
    public VertexInterface getSrc() {
        return src;
    }


}
