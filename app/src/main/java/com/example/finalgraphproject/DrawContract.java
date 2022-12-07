package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContract {

    interface CanvasContract {
        void dataUpdated();
        Integer[][] getTable();
    }

    interface DrawPresenter {
        void drawTable(Canvas canvas);
        void selectSquare(float touchX, float touchY);
        void render(Canvas canvas);
        void setSelected(Integer i);
        Integer[][] getTable();
    }

}