package com.centaurusa.note;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.google.common.base.Preconditions.checkNotNull;
import com.centaurusa.www.centaurusa.R;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    @Override
    public void setPresenter(NoteContract.Presenter presenter){
        mPresenter = checkNotNull(presenter);
    }
}
