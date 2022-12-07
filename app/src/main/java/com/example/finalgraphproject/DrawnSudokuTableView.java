package com.example.finalgraphproject;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawnSudokuTableView extends View implements DrawContract.CanvasContract {

    private DrawContract.DrawPresenter drawPresenter;

    public DrawnSudokuTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawPresenter = new Presenter(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPresenter.drawTable(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        Log.d("Touch Event", "X: " + touchX + ", Y: " + touchY);
        int action = event.getActionMasked();

        return true;
    }

    @Override
    public void dataUpdated() {
        postInvalidate();
    }



}
