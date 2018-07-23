package pt.ulisboa.tecnico.sise.dummynotepadlab02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNote extends AppCompatActivity {
    private static final String LOG_TAG = "SISE_app";
    private Button buttonOk;
    private Button buttonCancel;
    EditText editTextTitle;
    EditText editTextDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        buttonOk      = (Button)  findViewById(R.id.new_note_btn_ok);
        buttonCancel  = (Button)  findViewById(R.id.new_note_btn_cncl);
        editTextTitle = (EditText)findViewById(R.id.new_note_title);
        editTextDesc  = (EditText)findViewById(R.id.new_note_descr);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_TAG, "Hello this is my first debug message!");
                Log.d(LOG_TAG, editTextTitle.getText().toString());
                Intent intentListNotes = new Intent(getApplicationContext(), ListNotes.class);
                startActivity(intentListNotes);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            private int _counter = 1;
            public void onClick(View v) {
                buttonCancel.setText("Cancel-" + _counter++);
                //example of how to make toasts and snakbars
                Toast.makeText(v.getContext(), "Changed button title!", Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(android.R.id.content),"Changed button title!!",Snackbar.LENGTH_LONG).show();
                    //snackbars only available including "implementation 'com.android.support:design:27.1.1'" in build.gradle
            }
        });
    }
}