package com.example.mark.jnames.components;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mark.jnames.R;
import com.example.mark.jnames.datasource.LettersConverter;

/**
 * Created by Mark on 17.10.2017..
 */

public class TextFieldsComponent extends View {

    private EditText inputName = ((Activity)getContext()).findViewById(R.id.input_name);
    private TextView resultName = ((Activity)getContext()).findViewById(R.id.result_name);

    public TextFieldsComponent(Context context) {
        super(context);
    }

    public void handle() {

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
