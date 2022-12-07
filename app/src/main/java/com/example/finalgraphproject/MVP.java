package com.example.finalgraphproject;

public interface MVP {
    public interface ViewPresenter {
        void DisplayTable();
        Integer[][] getTable();
    }


    public interface Model {
        boolean solveTable(Integer[][] table);
    }
}
