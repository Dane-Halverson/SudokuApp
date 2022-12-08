package com.example.finalgraphproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;


public class Presenter implements DrawContract.DrawPresenter {

    private final DrawContract.CanvasContract view;

    /**
     * @param v canvas that contains this presenter
     */
    public Presenter(DrawContract.CanvasContract v) {
        view = v;

        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9 ; ++j) {
                tiles[i][j] = new Vertex();
            }
        }
    }

    /**
     * class for storing values at coordinates
     */
    private static class Vertex {
        public float x;
        public float y;
        public Integer val;
    }

    private final Vertex[][] tiles = new Vertex[9][9];

    private Vertex selected;

    /**
     * @param canvas the canvas to draw to
     * renders the current table
     */
    @Override
    public void render(Canvas canvas) {
        drawTable(canvas);


        if(selected != null) {
            Paint selectionSquare = new Paint();
            selectionSquare.setColor(Color.RED);
            selectionSquare.setStrokeWidth(9);
            float size = drawLength/18f-drawLength/500f;
            canvas.drawRect(selected.x+size, selected.y+size,
                    selected.x-size,
                    selected.y-size, selectionSquare);


        }
        drawValues(canvas);
    }

    Integer drawLength;
    final Integer m = 10;

    /**
     * @param canvas canvas to draw to
     */
    @Override
    public void drawTable(Canvas canvas) {
        Paint dimLine = new Paint();
        Integer w = canvas.getWidth();

        drawLength = w - m;
        dimLine.setStrokeWidth(5f);
        Integer space = drawLength/9;

        dimLine.setColor(Color.GRAY);

        for (int i = 0; i < 9; ++i) {

            canvas.drawLine(space*i+m, m, space*i+m, drawLength, dimLine  );
        }

        for (int i = 0; i < 9; ++i) {

            canvas.drawLine(m, space*i+m, drawLength, space*i+m, dimLine  );
        }

        Integer bigSpace = drawLength/3;

        Paint thickLine = new Paint();
        thickLine.setStrokeWidth(8f);
        thickLine.setColor(Color.BLACK);

        for (int i = 0; i < 3; ++i) {


            canvas.drawLine(bigSpace*i+m, m, bigSpace*i+m, drawLength, thickLine  );
        }

        canvas.drawLine(drawLength, m, drawLength, drawLength, thickLine  );


        for (int i = 0; i < 3; ++i) {


            canvas.drawLine(m, bigSpace*i+m, drawLength, bigSpace*i+m, thickLine  );
        }

        canvas.drawLine(m, drawLength, drawLength, drawLength, thickLine  );


        Integer tileMid = drawLength/9;

        dimLine.setTextSize(80f);

        for (int i = 1; i < 10; ++ i) {
            for (int j = 1; j < 10; ++j) {
                tiles[i-1][j-1].x = tileMid*j+m-tileMid/2f;
                tiles[i-1][j-1].y = tileMid*i+m-tileMid/2f;
                //canvas.drawCircle(tiles[i-1][j-1].x, tiles[i-1][j-1].y, 10, dimLine);
            }
        }

    }

    /**
     * @param x x coord of touch
     * @param y y coord of touch
     * selects the pressed square
     */
    @Override
    public void selectSquare(float x, float y){
        int xIdx;
        int yIdx;
        Integer canvas = drawLength+m;

        xIdx = (int) x/(canvas/9) ;
        yIdx = (int) y/(canvas/9);


        Log.d("Selected", "X: " + xIdx + ", Y: " + yIdx);


        selected = tiles[yIdx][xIdx];
        view.dataUpdated();


    }


    /**
     * @param canvas canvas to draw to
     * draws stored numbers on table
     */
    void drawValues(Canvas canvas) {
        Paint num = new Paint();
        num.setStrokeWidth(5);
        num.setColor(Color.BLACK);
        num.setTextSize(drawLength/10f);
        for (Vertex[] v: tiles) {
            for (Vertex vert: v) {
                if(vert.val != null) {
                    canvas.drawText(vert.val.toString(), vert.x-drawLength/40f, vert.y+drawLength/30f, num);
                }

            }
        }
    }


    /**
     * @param i number to set selected sqaure to
     */
    public void setSelected(Integer i) {
        if (selected != null) {
            selected.val = i;
        }



        view.dataUpdated();
    }

    /**
     * @return 2D array of integers corresponding to the values on the table
     */
    @Override
    public Integer[][] getTable() {
        Integer[][] table = new Integer[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                table[i][j] = tiles[i][j].val;

            }
        }
        return table;
    }
}


        // drawPaint.setColor(Color.GREEN);
        // canvas.drawCircle(50, 150, 20, drawPaint);
        // drawPaint.setColor(Color.BLUE);
        // canvas.drawCircle(50, 250, 20, drawPaint);

