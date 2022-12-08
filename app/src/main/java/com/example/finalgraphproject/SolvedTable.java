package com.example.finalgraphproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SolvedTable extends AppCompatActivity implements MVP.ViewPresenter {

    DrawnSudokuTableSolved draw;

    SudokuModel model = new SudokuModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_table);

        SudokuTable t = (SudokuTable) getIntent().getSerializableExtra("table");

        draw = findViewById(R.id.drawnSudokuTableSolved);

        draw.setTable(model.makeArray(t));

        DisplayTable();
    }


    @Override
    public void DisplayTable() {
        draw.dataUpdated();
    }

    @Override
    public Integer[][] getTable() {
        return new Integer[0][];
    }



    public void OnClickReturn(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);

    }
}