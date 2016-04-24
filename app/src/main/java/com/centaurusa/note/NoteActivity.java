package com.centaurusa.note;

import com.centaurusa.notedetial.EditNoteActivity;
import com.centaurusa.www.centaurusa.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class NoteActivity extends AppCompatActivity {

    private Button writeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        writeButton = (Button) findViewById(R.id.edit_note);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNote();
            }
        });
    }


    private void editNote() {
        Intent intent = new Intent(this, EditNoteActivity.class);
        startActivity(intent);
    }

}