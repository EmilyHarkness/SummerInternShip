package com.example.emily.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnToastTap;
    Button btnCountTap;
    Button btnRandomTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToastTap = (Button)findViewById(R.id.buttonToast);
        btnToastTap.setOnClickListener(this);
        btnCountTap = (Button)findViewById(R.id.buttonCount);
        btnCountTap.setOnClickListener(this);
        btnRandomTap = (Button)findViewById(R.id.buttonRandom);
        btnRandomTap.setOnClickListener(this);
    }

    private static final String TOTAL_COUNT = "total_count";
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonToast:
                Toast myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
                myToast.show();
                break;
            case R.id.buttonCount:
                TextView showCountTextView = (TextView) findViewById(R.id.textView1);
                String countString = showCountTextView.getText().toString();
                Integer count = Integer.parseInt(countString);
                count++;
                showCountTextView.setText(count.toString());
                break;
            case R.id.buttonRandom:
                Intent randomIntent = new Intent(this, SecondActivity.class);
                TextView showCountTextView2 = (TextView) findViewById(R.id.textView1);
                String countString2 = showCountTextView2.getText().toString();
                int count2 = Integer.parseInt(countString2);
                randomIntent.putExtra(TOTAL_COUNT, count2);
                startActivity(randomIntent);
                break;
        }
    }
}
