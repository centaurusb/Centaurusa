package com.centaurusa.notedetial;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

import com.centaurusa.www.centaurusa.R;

/**
 * Created by Administrator on 2016/4/6.
 */
public class NoteEditText extends EditText {
    private int defaultDrawLine = 10;

    private int mDrawLineColor = 0;
    private int textLineDis = 0;

    private int mStrokeWidth = 0;
    private Rect mRect;
    private Paint mPaint;


    public NoteEditText(Context context) {
        super(context, null);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        final Resources res = context.getResources();
        mDrawLineColor = res.getColor(R.color.edit_text_line_color);
        textLineDis = res.getDimensionPixelSize(R.dimen.dis_between_text_and_line);
        mStrokeWidth = res.getDimensionPixelSize(R.dimen.edit_text_paint_stroke_width);
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setColor(mDrawLineColor);
    }


    public void setDefaultLine(int defaultLine){
        this.defaultDrawLine = defaultLine;
        setMinLines(defaultLine);
    }

    @Override
    public void onDraw(Canvas canvas){
        final int count = getLineCount();
        final Rect r = mRect;
        final Paint paint = mPaint;
        int basicLine = 0;
        int lineYBound = 0;

        basicLine = getLineBounds(0,r) + textLineDis;

        for(int i=0; i<defaultDrawLine; i++){
            lineYBound = basicLine + i * getLineHeight();
            canvas.drawLine(r.left, lineYBound, r.right, lineYBound, paint);
        }

        if(count > defaultDrawLine){
            for(int j=defaultDrawLine; j<count; j++){
                lineYBound = basicLine + j * getLineHeight();
                canvas.drawLine(r.left, lineYBound, r.right, lineYBound, paint);
            }
        }

        super.onDraw(canvas);
    }

}
