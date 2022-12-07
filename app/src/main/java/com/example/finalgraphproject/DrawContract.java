package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContract {

    interface CanvasContract {
        void dataUpdated();

    }

    interface DrawPresenter {
        void drawTable(Canvas canvas);
        void getBox( float x, float y );
        void setBox();
    }

}