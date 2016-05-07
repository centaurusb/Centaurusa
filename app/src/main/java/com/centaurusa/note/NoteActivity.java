package com.centaurusa.note;

import com.centaurusa.www.centaurusa.R;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class NoteActivity extends AppCompatActivity {
    private static final String TAG = "NoteActivity.Class";
    private Toolbar mToolbar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //set the toolbar
        mToolbar = (Toolbar)findViewById(R.id.note_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

    }

}
