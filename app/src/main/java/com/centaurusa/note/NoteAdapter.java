package com.centaurusa.note;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.centaurusa.data.Note;
import com.centaurusa.utils.DrawableUtils;
import com.centaurusa.www.centaurusa.R;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;

import java.util.List;

/**
 * Created by Swin on 2016/5/23.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>
        implements DraggableItemAdapter<NoteAdapter.NoteViewHolder> {
    private static final String TAG = "NoteAdater";
    private List<Note> mNotes;

    private interface Draggable extends DraggableItemConstants {

    }

    public NoteAdapter(List<Note> notes) {
        mNotes = notes;
    }

    public static class NoteViewHolder extends AbstractDraggableItemViewHolder {
        private FrameLayout mContainer;
        private View mView;
        private TextView mTextView;

        private Note mNote;

        public NoteViewHolder(View v) {
            super(v);
            mContainer = (FrameLayout) v.findViewById(R.id.item_container);
            mView = v.findViewById(R.id.item_drag_handle);
            mTextView = (TextView) v.findViewById(R.id.item_text_view);
        }

        public void bindNote(Note note) {
            mTextView.setText(note.getTitle());
        }
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = mNotes.get(position);
        holder.bindNote(note);

        //set background resource
        int dragState = holder.getDragStateFlags();

        if (((dragState & Draggable.STATE_FLAG_IS_UPDATED) != 0)) {
            int bgResId;
            if ((dragState & Draggable.STATE_FLAG_IS_ACTIVE) != 0) {
                bgResId = R.drawable.bg_item_dragging_active_state;
                // need to clear drawable state here to get correct appearance of the dragging item.
                DrawableUtils.clearState(holder.mContainer.getForeground());
            }else if((dragState & Draggable.STATE_FLAG_DRAGGING) != 0){
                bgResId = R.drawable.bg_item_dragging_state;
            }else
                bgResId = R.drawable.bg_item_normal_state;

            holder.mContainer.setBackgroundResource(bgResId);
        }

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    @Override
    public boolean onCheckCanStartDrag(NoteViewHolder holder, int position, int x, int y) {
        return false;
    }

    @Override
    public ItemDraggableRange onGetItemDraggableRange(NoteViewHolder holder, int position) {
        return null;
    }

    @Override
    public void onMoveItem(int fromPosition, int toPosition) {

    }

    @Override
    public boolean onCheckCanDrop(int draggingPosition, int dropPosition) {
        return false;
    }
}
