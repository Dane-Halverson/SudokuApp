package com.example.finalgraphproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.os.Handler;

import java.security.PublicKey;
import java.util.LinkedList;

public class Presenter implements DrawContract.DrawPresenter {

    private DrawContract.CanvasContract view;

    public Presenter(DrawContract.CanvasContract v) {
        view = v;

        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9 ; ++j) {
                tiles[i][j] = new Vertex();
            }
        }
    }

    private class Vertex {
        public float x;
        public float y;
        public Integer val;
    }

    private final Vertex[][] tiles = new Vertex[9][9];

    private Vertex selected;

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

    @Override
    public void selectSquare(float x, float y){
        Float max = Float.MAX_VALUE-100;
        int xIdx = 0;
        int yIdx = 0;
        Integer canvas = drawLength+m;

        xIdx = (int) x/(drawLength/9) ;
        yIdx = (int) y/(drawLength/9);

        /*

        for (int i = 0; i < 9; ++i) {
            if (Math.abs(tiles[0][i].x-x) < Math.abs(tiles[0][i].x-max)) {
                xIdx = i;
                max = tiles[0][i].x;

            }
        }
        max = Float.MAX_VALUE-100;
        for (int i = 0; i < 9; ++i) {
            if (Math.abs(tiles[i][0].y-y) < Math.abs(tiles[i][0].y-max)) {
                yIdx = i;
                max = tiles[i][0].y;
            }
        }
        */
        Log.d("Selected", "X: " + xIdx + ", Y: " + yIdx);


        selected = tiles[yIdx][xIdx];
        view.dataUpdated();


    }



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


    public void setSelected(Integer i) {
        if (selected != null) {
            selected.val = i;
        }



        view.dataUpdated();
    }

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

