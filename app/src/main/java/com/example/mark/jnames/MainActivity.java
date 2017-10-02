package com.example.mark.jnames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mark.jnames.datasource.LettersConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputName = (EditText)findViewById(R.id.input_name);
        final TextView resultName = (TextView)findViewById(R.id.result_name);

        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), Integer.toString(after), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                determineJapaneseName(s, start, before, count);
            }

            private void determineJapaneseName(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    String currentLetter = Character.toString(s.charAt(start + (count - 1))).toUpperCase();

                    if (before < count && LettersConverter.generateLettersMap().containsKey(currentLetter)) {
                        resultName.append(LettersConverter.generateLettersMap().get(currentLetter));
                    }
                }

                else {
                    resultName.setText("See your Japanese name: ");
                }
            }
        });
    }
}
