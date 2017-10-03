package com.example.mark.jnames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

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
            }

            /**
             * Triggers when the text is now changed.
             *
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                determineJapaneseName(s, start, before, count);
            }

            /**
             * Replaces each letter with Japanese spelling of Japanese letter
             *
             * @param s
             * @param start
             * @param before
             * @param count
             */
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
