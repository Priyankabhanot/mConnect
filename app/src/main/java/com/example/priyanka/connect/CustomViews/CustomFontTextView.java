package com.example.priyanka.connect.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.priyanka.connect.R;

/**
 * Created by priyanka on 2/9/16.
 */
public class CustomFontTextView extends TextView {
    String fontName;
    private boolean isNormalText = false;

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public CustomFontTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.fontTextView);
            String fontName = a.getString(R.styleable.fontTextView_fontName);
            isNormalText = a.getBoolean(R.styleable.fontTextView_normal_text,false);
            if (fontName!=null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+fontName);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }
    @Override
    public void setText(CharSequence text, BufferType type) {
        if(!TextUtils.isEmpty(text)) {
            if(text instanceof SpannableStringBuilder) {
                super.setText(text, type);
                return;
            }
            if(!isNormalText) {
                super.setText(text.toString().toLowerCase(), type);
            }
            else{
                super.setText(text.toString(),type);
            }
        } else {
            super.setText(text, type);
        }
    }
    public void setFontName(String fontName) {
        this.fontName = fontName;
        if (fontName != null) {
            Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
            setTypeface(myTypeface);
        }
    }
}
