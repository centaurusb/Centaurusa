package com.centaurusa.note;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.google.common.base.Preconditions.checkNotNull;

import com.centaurusa.data.Note;
import com.centaurusa.www.centaurusa.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment implements NoteContract.View{
    private static final String TAG = "NoteFragment";
    private NoteContract.Presenter mPresenter ;

    public NoteFragment() {

    }

    public static NoteFragment newInstance() {
        NoteFragment noteFragment = new NoteFragment();
        return noteFragment;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_note,container,false);
        return rootView;
    }

    @Override
    public void setPresenter(NoteContract.Presenter presenter){
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showNotes(List<Note> notes) {

    }
}
