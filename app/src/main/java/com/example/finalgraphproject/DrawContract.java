package com.example.finalgraphproject;

import android.graphics.Canvas;

public interface DrawContract {

    interface CanvasContract {

        /**
         * updates canvas
         */
        void dataUpdated();

        /**
         * @return 2D array of table values from presenter
         */
        Integer[][] getTable();
    }

    interface DrawPresenter {

        /**
         * @param touchX x touch coord
         * @param touchY y touch coord
         * selects square based on touch
         */
        void selectSquare(float touchX, float touchY);

        /**
         * @param canvas renders the canvas (table, values, selection)
         */
        void render(Canvas canvas);

        /**
         * @param i number to set selected square to
         */
        void setSelected(Integer i);

        /**
         * @return 2D array of table values
         */
        Integer[][] getTable();
    }

}