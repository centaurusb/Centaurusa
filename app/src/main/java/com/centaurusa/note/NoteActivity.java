package com.centaurusa.note;

import com.centaurusa.data.NoteDataRepository;
import com.centaurusa.data.LocalNoteDataSource;
import com.centaurusa.utils.ActivityUtils;
import com.centaurusa.www.centaurusa.R;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class NoteActivity extends AppCompatActivity {
    private static final String TAG = "NoteActivity";
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private NotePresenter mNotePresenter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //set the toolbar
        mToolbar = (Toolbar) findViewById(R.id.note_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        //set the navigation
        mDrawerLayout = (DrawerLayout)findViewById(R.id.note_drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.navigation_draw_open,R.string.navigation_draw_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView)findViewById(R.id.note_nav_view);

        //create the fragment
        NoteFragment noteFragment = (NoteFragment)getSupportFragmentManager()
                .findFragmentById(R.id.note_fragment_container);
        if(noteFragment == null){
            noteFragment = NoteFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    noteFragment,R.id.note_fragment_container);
        }

        //set the presenter
       mNotePresenter = new NotePresenter(NoteDataRepository.getInstance(LocalNoteDataSource.getIntance()),
               noteFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
