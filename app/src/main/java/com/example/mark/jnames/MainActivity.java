package com.example.mark.jnames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mark.jnames.components.TextFieldsComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new TextFieldsComponent(this).handle();
    }
}
