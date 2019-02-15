package com.example.appwithintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        textView=findViewById(R.id.textViewActivity2);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String text=bundle.get(Intent.EXTRA_TEXT).toString();
        textView.setText(text);
    }

    public void clickOnTextView(View v){
        Intent intent=new Intent();
        intent.setType("text/plain");
        intent.putExtra("RESULT_TEXT","Clicked2");
        setResult(RESULT_OK,intent);
        finish();
    }
}
