package com.sun.designdemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class TextActivity extends AppCompatActivity implements TextWatcher, View.OnFocusChangeListener {

    private TextInputLayout text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        text = (TextInputLayout) findViewById(R.id.text_input);
        text.getEditText().addTextChangedListener(this);
        text.getEditText().setOnFocusChangeListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    // Text改变即判断
    @Override
    public void afterTextChanged(Editable s) {
        //判断
        if (s.length() == 11 || s.length()==0){
            text.setErrorEnabled(false);
        }else{
            text.setErrorEnabled(true);
            text.setError("电话号码必须是11位");
        }
    }

    // 失去焦点时再判断（当Activity只有一个EditText的时候，不会失去焦点，可以在这里设置判断）
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
       /* if (!hasFocus){
            EditText editText = (EditText) v;
           String s = editText.getText().toString();
            //判断
            if (s.length() == 11 || s.length()==0){
                text.setErrorEnabled(false);
            }else{
                text.setErrorEnabled(true);
                text.setError("电话号码必须是11位");
            }
        }*/

    }
}
