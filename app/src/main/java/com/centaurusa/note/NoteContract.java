package com.centaurusa.note;

import com.centaurusa.base.BasePresenter;
import com.centaurusa.base.BaseView;

/**
 * Created by Swin on 2016/5/21.
 */
public interface NoteContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void loadNotes();

        void addNote();

        void deleteNote();
    }
}
