package com.example.appwithintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    TextView textView;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        textView=findViewById(R.id.textViewActivity2);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String text=bundle.get(Intent.EXTRA_TEXT).toString();
        try{
            String calcResult=Double.toString(calculate(text));
            result="Result of: " +text+" is: "+ calcResult;
            textView.setText(result);
        }
        catch (Exception e){
            Intent intentException=new Intent();
            intentException.setType("text/plain");
            intentException.putExtra("RESULT_TEXT","Wrong data in editText!");
            setResult(RESULT_CANCELED,intentException);
            finish();
        }
    }

    private double calculate(String text) {
        List<String> operators=new ArrayList<>();
        operators.add("/");
        operators.add("*");
        operators.add("+");
        operators.add("-");
        operators.add("×");
        int indexOfoperator=0;
        for(String s:operators){
            if (text.contains(s)){
                indexOfoperator=text.indexOf(s);
            }
        }
        double arg1=Double.parseDouble(text.substring(0,indexOfoperator));
        double arg2=Double.parseDouble(text.substring(indexOfoperator+1,text.length()));
        double result=0;
        switch (text.charAt(indexOfoperator)){
            case '/':
                result=arg1/arg2;
                break;
            case '*':
                result=arg1*arg2;
                break;
            case '×':
                result=arg1*arg2;
                break;
            case '+':
                result=arg1+arg2;
                break;
            case '-':
                result=arg1-arg2;
                break;
        }
        return result;
    }

    public void clickOnTextView(View v){
        Intent intent=new Intent();
        intent.setType("text/plain");
        intent.putExtra("RESULT_TEXT",result);
        setResult(RESULT_OK,intent);
        finish();
    }
}
