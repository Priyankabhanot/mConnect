package com.example.priyanka.connect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.priyanka.connect.CustomViews.CustomFontButton;
import com.example.priyanka.connect.CustomViews.CustomFontTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by priyanka on 2/9/16.
 */
public class YourAnswerActivity extends AppCompatActivity {
    @Bind(R.id.questionTv)
    CustomFontTextView mQuestionTv;
    @Bind(R.id.answerTv) CustomFontTextView mAnswerTv;
    @Bind(R.id.likeCountTv) CustomFontTextView mLikeCount;
    @Bind(R.id.dislikeCountTv) CustomFontTextView mDislikeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qa_layout);
        ButterKnife.bind(this);

        if(getIntent().getExtras() != null){
             String question = getIntent().getExtras().get("question").toString();
            String answer = getIntent().getExtras().get("answer").toString();
            String  likeCount = getIntent().getExtras().getString("likeCount");
            String dislikeCount = getIntent().getExtras().getString("dislikeCount");

            mQuestionTv.setText(question);
            mAnswerTv.setText(answer);
            mLikeCount.setText(likeCount);
            mDislikeCount.setText(dislikeCount);
        }

    }

    @OnClick(R.id.doneBtn) void onDone(){
        finish();
    }
}