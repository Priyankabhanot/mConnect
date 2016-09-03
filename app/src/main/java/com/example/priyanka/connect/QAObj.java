package com.example.priyanka.connect;

/**
 * Created by priyanka on 1/9/16.
 */
public class QAObj {
    String mQuestion;
    String mAnswer;

    public Boolean getmIsExpanded() {
        return mIsExpanded;
    }

    public void setmIsExpanded(Boolean mIsExpanded) {
        this.mIsExpanded = mIsExpanded;
    }

    Boolean mIsExpanded;

    public Boolean getEarned() {
        return isEarned;
    }

    public void setEarned(Boolean earned) {
        isEarned = earned;
    }

    Boolean isEarned;

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }

    public int getmRating() {
        return mRating;
    }

    public void setmRating(int mRating) {
        this.mRating = mRating;
    }

    public String getmTimeStamp() {
        return mTimeStamp;
    }

    public void setmTimeStamp(String mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    int mRating;
    String mTimeStamp;

    public QAObj(String mQuestion, String mAnswer, int mRating, String mTimeStamp, Boolean isEarned){
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
        this.mRating = mRating;
        this.mTimeStamp = mTimeStamp;
        this.isEarned = isEarned;
        this.mIsExpanded = false;
    }
}
