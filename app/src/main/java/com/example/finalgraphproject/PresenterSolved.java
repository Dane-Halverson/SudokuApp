package com.example.finalgraphproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PresenterSolved implements DrawContractSolved.DrawPresenter {

    private static class Vertex {
        public float x;
        public float y;
        public Integer val;
    }

    public void setTable(Integer [][] table) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                tiles[i][j].val = table[i][j];
            }
        }
    }


    private final DrawContractSolved.DrawingView view;

    private final Vertex[][] tiles = new Vertex[9][9];

    public PresenterSolved(DrawContractSolved.DrawingView v) {
        view = v;


        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9 ; ++j) {
                tiles[i][j] = new Vertex();
            }
        }
    }

    Integer drawLength;

    @Override
    public void drawTable(Canvas canvas) {
        Paint dimLine = new Paint();
        Integer w = canvas.getWidth();
        final Integer m = 10;
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
    public void render(Canvas canvas) {
        drawTable(canvas);
        drawNumbers(canvas);
    }

    @Override
    public void drawNumbers(Canvas canvas) {
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



}
