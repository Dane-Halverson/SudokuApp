package com.example.finalgraphproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MVP.ViewPresenter {

    DrawnSudokuTableView d;

    SudokuModel model = new SudokuModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d = (DrawnSudokuTableView) findViewById(R.id.sudokuTable);

        d.dataUpdated();

    }


    public void OnClickOne(View view) {
        d.SetTile(1);
        d.dataUpdated();
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

    public void OnClickSolve(View view) {
        Intent showSolved = new Intent(this, SolvedTable.class);
        Bundle table = new Bundle();
        SudokuTable t = model.makeSudokuTable(d.getTable());
        if(!model.solveTable(t)) {
            Toast toast = new Toast(this);
            toast.setText("Table Not Solvable");
            toast.show();
        }
        else {
            table.putSerializable("table", t);
            showSolved.putExtras(table);
            startActivity(showSolved);
        }
        t.printTable();



    }


    @Override
    public void DisplayTable() {

    }

    @Override
    public Integer[][] getTable() {
        return new Integer[0][];
    }


}