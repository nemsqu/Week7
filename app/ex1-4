package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.view.inputmethod.EditorInfo;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextInputEditText input;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        input = (TextInputEditText) findViewById(R.id.editText);
        input.setOnEditorActionListener(editorListener);

    }

    public void print(View v){
        temp = input.getText().toString();
        text.setText(temp);

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEND:
                    temp = input.getText().toString();
                    text.setText(temp);
                    break;
            }
            return false;
        }
    };
}

