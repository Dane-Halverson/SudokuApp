package com.example.finalgraphproject;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawnSudokuTableView extends View implements DrawContract.CanvasContract {

    private final DrawContract.DrawPresenter drawPresenter;




    public DrawnSudokuTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawPresenter = new Presenter(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPresenter.render(canvas);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        Log.d("Touch Event", "X: " + touchX + ", Y: " + touchY);
        int action = event.getActionMasked();
        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d("Touch Event Type: ", "Action MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d("Touch Event Type: ", "Action UP");
                drawPresenter.selectSquare(touchX, touchY);
                // postInvalidate();
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d("Touch Event Type:", "Action CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d("Touch Event Type: ", "Action OUTSIDE");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    public void SetTile(Integer i) {
        drawPresenter.setSelected(i);
    }

    @Override
    public void dataUpdated() {

        postInvalidate();

    }

    @Override
    public Integer[][] getTable() {
       return drawPresenter.getTable();
    }


}
