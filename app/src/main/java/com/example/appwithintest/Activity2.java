package com.example.appwithintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView=findViewById(R.id.textViewActivity1);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("TEXT_FROM_MAIN"));
    }

    public void clickOnTextView(View v){
        Intent intent=new Intent();
        intent.setType("text/plain");
        intent.putExtra("RESULT_TEXT","Clicked1");
        setResult(RESULT_OK,intent);
        finish();
    }
}
