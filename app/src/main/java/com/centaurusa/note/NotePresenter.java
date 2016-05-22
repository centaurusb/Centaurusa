package com.centaurusa.note;

import android.support.annotation.NonNull;

import com.centaurusa.base.NoteDataSource;
import com.centaurusa.data.Note;
import com.centaurusa.data.NoteDataRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Swin on 2016/5/22.
 */
public class NotePresenter implements NoteContract.Presenter {
    private final NoteDataRepository mDataRepository;
    private final NoteContract.View mNoteView;

    public NotePresenter(@NonNull NoteDataRepository dataRepository,
                         @NonNull NoteContract.View noteView) {
        mDataRepository = checkNotNull(dataRepository, "data respository cannot be null");
        mNoteView = checkNotNull(noteView, "note view cannot be null");

        // set presenter to NoteFragment
        mNoteView.setPresenter(this);
    }

    @Override
    public void start() {
        loadNotes();
    }

    @Override
    public void loadNotes() {
        mDataRepository.getNotes(new NoteDataSource.LoadNotesCallback() {
            @Override
            public void onNotesLoaded(List<Note> notes) {
                mNoteView.showNotes(notes);
            }
        });
    }

    @Override
    public void addNote() {

    }

    @Override
    public void deleteNote() {

    }
}
