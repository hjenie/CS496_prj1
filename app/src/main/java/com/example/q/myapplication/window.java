package com.example.q.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class window extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        Button todo = (Button)findViewById(R.id.button);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                EditText todo_input = (EditText) findViewById(R.id.todo_input);
                intent.putExtra("data",todo_input.getText().toString());
                setResult(1, intent);
                finish();
            }
        });
    }
}
