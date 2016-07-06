package jp.techacademy.takefumi.onishi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textans;
    double value1;
    double value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button backbutton = (Button) findViewById(R.id.textback);
        textans = (TextView) findViewById(R.id.textans);
        backbutton.setOnClickListener(this);
        Intent intent = getIntent();
        value1 = intent.getDoubleExtra("edit1", 0);
        value2 = intent.getDoubleExtra("edit2", 0);
        int type = intent.getIntExtra("type", 0);
        switch (type) {
            case 1:
                textans.setText(String.valueOf(value1 + value2));
                break;
            case 2:
                textans.setText(String.valueOf(value1 - value2));
                break;
            case 3:
                textans.setText(String.valueOf(value1 * value2));
                break;
            case 4:
                textans.setText(String.valueOf(value1 / value2));
                break;
            default:
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
