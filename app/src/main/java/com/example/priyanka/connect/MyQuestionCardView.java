package com.example.priyanka.connect;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by priyanka on 1/9/16.
 */
public class MyQuestionCardView extends LinearLayout {

    @Bind(R.id.questionTv) TextView mQuestionTv;
    @Bind(R.id.answerTv) TextView mAnswerTv;
    @Bind(R.id.ratingTv) TextView mRatingTv;
    @Bind(R.id.timeTv) TextView mTimeTv;
    @Bind(R.id.answerLayout) RelativeLayout mAnswerLayout;

    Context mContext;
    QAObj mQaDataItem;

    public MyQuestionCardView(Context context) {
        super(context);
    }

    public MyQuestionCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyQuestionCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyQuestionCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void populateData(Object data) {
        ButterKnife.bind(this, this);
        if (!(data instanceof QAObj)) {
            return;
        }
        mQaDataItem = (QAObj) data;
        mQuestionTv.setText(mQaDataItem.getmQuestion());

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQaDataItem.getEarned() && ! TextUtils.isEmpty(mQaDataItem.getmAnswer()) && !mQaDataItem.getmIsExpanded()){
                    mAnswerTv.setText(mQaDataItem.getmAnswer());
                    mTimeTv.setText(String.valueOf(mQaDataItem.getmTimeStamp()));
                    mRatingTv.setText(String.valueOf(mQaDataItem.getmRating()));
                    mAnswerLayout.setVisibility(VISIBLE);
                    mQaDataItem.setmIsExpanded(true);
                }else if(mQaDataItem.getmIsExpanded()){
                    mAnswerLayout.setVisibility(GONE);
                    mQaDataItem.setmIsExpanded(false);
                }

            }
        });


    }




}
