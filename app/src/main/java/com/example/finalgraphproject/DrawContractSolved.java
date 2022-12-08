package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContractSolved {

    interface DrawingView {
        void dataUpdated();
    }

    interface DrawPresenter {
        void drawTable(Canvas canvas);
        void render(Canvas canvas);
        void drawNumbers(Canvas canvas);
        void setTable(Integer[][] table);
    }
}
