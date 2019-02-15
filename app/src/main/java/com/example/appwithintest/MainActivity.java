package com.example.appwithintest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonIntent;
    Button buttonHideIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonIntent=findViewById(R.id.buttonIntent);
        buttonHideIntent=findViewById(R.id.buttonHideIntent);

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
            String tetx=data.getStringExtra("RESULT_TEXT");
            Log.d("resultOfIntent","yes");
            buttonIntent.setText(tetx);
        }
    }

    public void onHideClick(View v){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hide Intent text");
        intent.setType("text/plain");

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
