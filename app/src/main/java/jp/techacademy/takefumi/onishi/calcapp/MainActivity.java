package jp.techacademy.takefumi.onishi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);
        Button buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);
        Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);
        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);

    }

    @Override
    public void onClick(View view) {
        int type = 0;
        if (view.getId() == R.id.buttonAdd)
            type = 1;/*ADD*/
        if (view.getId() == R.id.buttonSub)
            type = 2;/*SUB*/
        if (view.getId() == R.id.buttonMul)
            type = 3;/*MUL*/
        if (view.getId() == R.id.buttonDiv)
            type = 4;/*DIV*/
/*        switch (view.getId()) {
            case:R.id.buttonAdd:
            type = 1;*//*ADD*//*
            break;
            case:R.id.buttonSub:
            type = 2;*//*SUB*//*
            break;
            case:R.id.buttonMul:
            type = 3;*//*MUL*//*
            break;
            case:R.id.buttonDiv:
            type = 4;*//*DIV*//*
            break;
            default:
        }*/
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("edit1", Double.parseDouble(editText1.getText().toString()));
        intent.putExtra("edit2", Double.parseDouble(editText2.getText().toString()));
        intent.putExtra("type", type);

        startActivity(intent);
    }
}
