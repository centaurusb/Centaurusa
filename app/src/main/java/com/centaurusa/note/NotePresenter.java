package com.centaurusa.note;

import android.support.annotation.NonNull;

import com.centaurusa.data.NoteDataRepository;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by Swin on 2016/5/22.
 */
public class NotePresenter implements NoteContract.Presenter {
    private final NoteDataRepository mDataRepository;
    private final NoteContract.View mNoteView;

    public NotePresenter(@NonNull NoteDataRepository dataRepository,
                         @NonNull NoteContract.View noteView){
        mDataRepository = checkNotNull(dataRepository,"data respository cannot be null");
        mNoteView = checkNotNull(noteView,"note view cannot be null");
        mNoteView.setPresenter(this);
    }
    @Override
    public void start(){

    }

    @Override
    public void loadNotes() {

    }

    @Override
    public void addNote() {

    }

    @Override
    public void deleteNote() {

    }
}
