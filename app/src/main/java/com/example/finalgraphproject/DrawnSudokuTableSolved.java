package com.example.finalgraphproject;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class DrawnSudokuTableSolved extends View implements DrawContractSolved.DrawingView {

    private final DrawContractSolved.DrawPresenter drawPresenter;


    public DrawnSudokuTableSolved(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawPresenter = new PresenterSolved(this);
    }

    public void setTable (Integer[][] table) {
            drawPresenter.setTable(table);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPresenter.render(canvas);
    }

    @Override
    public void dataUpdated() {

    }
}
