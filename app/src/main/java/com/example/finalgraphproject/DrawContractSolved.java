package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContractSolved {

    public interface DrawingView {
        void dataUpdated();
    }

    public interface DrawPresenter {
        void drawTable(Canvas canvas);
        void render(Canvas canvas);
        void drawNumbers(Canvas canvas);
        void setTable(Integer[][] table);
    }
}
