package com.example.finalgraphproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class DrawnSudokuTableSolved extends View implements DrawContractSolved.DrawingView {

    private DrawContractSolved.DrawPresenter drawPresenter;


    public DrawnSudokuTableSolved(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawPresenter = new PresenterSolved(this);
    }

    @Override
    public void dataUpdated() {

    }
}
