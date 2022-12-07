package com.example.finalgraphproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.view.View;
import android.os.Handler;

import java.util.LinkedList;

public class Presenter implements DrawContract.DrawPresenter {

    private DrawContract.CanvasContract view;

    public Presenter(DrawContract.CanvasContract v) {
        view = v;
        vertices = new LinkedList<>();
    }

    class Vertex {
        public float xpos;
        public float ypos;
        public float radius;

        public Vertex(float x, float y, float r) {
            xpos = x;
            ypos = y;
            radius = r;
        }
    }
    LinkedList<Vertex> vertices;

    @Override
    public void drawTable(Canvas canvas) {
        Paint dimLine = new Paint();
        Integer w = canvas.getWidth();
        final Integer m = 15;
        Integer drawLength= w-m;
        dimLine.setStrokeWidth(5f);



        canvas.drawLine(0, w/2f, w, w/2f, dimLine);

        /*
        for (int i = 0; i < 10; ++i)
            dimLine.setColor(Color.GRAY);
            int xpos = w - m + (i * (w / 9));
            canvas.drawLine(xpos, m, w-drawLength+xpos, w-drawLength, dimLine);
        }

         */
        // drawPaint.setColor(Color.GREEN);
        // canvas.drawCircle(50, 150, 20, drawPaint);
        // drawPaint.setColor(Color.BLUE);
        // canvas.drawCircle(50, 250, 20, drawPaint);
    }

    @Override
    public void getBox(float x, float y) {

    }

    @Override
    public void setBox() {

    }


}
