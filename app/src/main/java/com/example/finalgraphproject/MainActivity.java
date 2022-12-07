package com.example.finalgraphproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    DrawnSudokuTableView d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d = (DrawnSudokuTableView) findViewById(R.id.sudokuTable);

        d.dataUpdated();

    }


    public void OnClickOne(View view) {
        view.setBackground(AppCompatResources.getDrawable(this, R.drawable.tile_pressed));
        d.SetTile(1);
        d.dataUpdated();

        view.setBackground(AppCompatResources.getDrawable(this, R.drawable.tile_border));
    }

    public void OnClickTwo(View view) {
        d.SetTile(2);
        d.dataUpdated();
    }

    public void OnClickThree(View view) {
        d.SetTile(3);
        d.dataUpdated();
    }

    public void OnClickFour(View view) {
        d.SetTile(4);
        d.dataUpdated();
    }

    public void OnClickFive(View view) {
        d.SetTile(5);
        d.dataUpdated();
    }

    public void OnClickSix(View view) {
        d.SetTile(6);
        d.dataUpdated();
    }

    public void OnClickSeven(View view) {
        d.SetTile(7);
        d.dataUpdated();
    }

    public void OnClickEight(View view) {
        d.SetTile(8);
        d.dataUpdated();
    }

    public void OnClickNine(View view) {
        d.SetTile(9);
        d.dataUpdated();
    }

    public void OnClickDelete(View view) {
        d.SetTile(null);
        d.dataUpdated();
    }


}