package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText text;
    TextInputEditText input;
    String temp;
    Context context = null;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.text);
        input = (TextInputEditText) findViewById(R.id.editText);
        context = MainActivity.this;
        System.out.println(" TÄMÄ" + context.getFilesDir());

    }

    public void readFile(View v){
        try{
            InputStream streamIn = context.openFileInput(Objects.requireNonNull(input.getText()).toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(streamIn));
            String s = "";
            String s2 = "";
            while((s=br.readLine()) != null) {
                s2 = s2 + s + "\n";
            }
            text.setText(s2);
            br.close();

        }catch(IOException e){
            Log.e("IoException", "Error");
        }
    }

    public void writeFile (View v){
        try{
            OutputStreamWriter streamOut = new OutputStreamWriter(context.openFileOutput(input.getText().toString(), Context.MODE_PRIVATE));
            String s = text.getText().toString();
            streamOut.write(s);
            streamOut.close();
        }catch(IOException e){
            Log.e("IoException", "Error");
        }
    }

}

