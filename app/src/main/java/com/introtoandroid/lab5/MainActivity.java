package com.introtoandroid.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText newName;
    TextView DefaultName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String defaultStr = "Brandi";

        submit = (Button) findViewById(R.id.button);
        newName = (EditText) findViewById(R.id.editText);
        DefaultName = (TextView) findViewById(R.id.defaultName);

        //check if there is a key/value pair
        //if so set name as name else set name as default
        final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        final String currentName = sharedPref.getString("Name", defaultStr);
        DefaultName.setText(currentName);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("info","In Click Listener");
                if(newName.getText().toString()!=null){
                    Log.i("info", "not null");
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Name", newName.getText().toString());
                    editor.apply();
                    DefaultName.setText(sharedPref.getString("Name", defaultStr));
                }
            }
        });


    }
}
