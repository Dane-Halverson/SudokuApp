package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContractSolved {

    public interface DrawingView {
        void dataUpdated();
    }

    public interface DrawPresenter {
        void drawTable(Canvas canvas);
        void Render(Canvas canvas, Integer[][] table);
        void drawNumbers(Canvas canvas, Integer[][] table);
    }
}
