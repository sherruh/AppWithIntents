package com.example.appwithintest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonIntent;
    Button buttonHideIntent;
    EditText editText1;
    String textFromEditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonIntent=findViewById(R.id.buttonIntent);
        buttonHideIntent=findViewById(R.id.buttonHideIntent);
        editText1=findViewById(R.id.editext1);


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textFromEditText1=editText1.getText().toString();
            }
        });


        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                intent.setType("tetx/plain");
                intent.putExtra("TEXT_FROM_MAIN","Text from main Activity");
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            String text=data.getStringExtra("RESULT_TEXT");
            switch (text){
                case "Clicked1":
                    buttonIntent.setText(text);
                    break;
                case "Clicked2":
                    buttonHideIntent.setText(text);
                    break;
            }
        }
    }

    public void onHideClick(View v){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hide Intent text");
        intent.setType("text/plain");

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,1);
        }
    }
}
