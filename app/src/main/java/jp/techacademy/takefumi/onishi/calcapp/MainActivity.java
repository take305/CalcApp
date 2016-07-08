package jp.techacademy.takefumi.onishi.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1;
    EditText editText2;
    int type;
    AlertDialog.Builder alertInput;

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
        alertInput = new AlertDialog.Builder(this);
        alertInput.setTitle(" 入力エラー!");
        alertInput.setMessage("５桁までの整数を入力してください");
        alertInput.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("CALC", "error");
            }
        });
    }

    Boolean isCheckNumber(String string) {

        if (!string.matches("-?[0-9]{0,5}")) {
            alertInput.create().show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {

        String edit1Number = editText1.getText().toString();
        String edit2Number = editText2.getText().toString();

        if (!isCheckNumber(edit1Number))
            return;
        if (!isCheckNumber(edit2Number))
            return;

        if (view.getId() == R.id.buttonAdd)
            type = Globals.TYPE_ADD;/*ADD*/
        if (view.getId() == R.id.buttonSub)
            type = Globals.TYPE_SUB;/*SUB*/
        if (view.getId() == R.id.buttonMul)
            type = Globals.TYPE_MUL;/*MUL*/
        if (view.getId() == R.id.buttonDiv)
            type = Globals.TYPE_DEV;/*DIV*/

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("edit1", Double.parseDouble(edit1Number));
        intent.putExtra("edit2", Double.parseDouble(edit2Number));
        intent.putExtra("type", type);

        startActivity(intent);
    }

}
