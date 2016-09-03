package com.example.priyanka.connect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyanka on 1/9/16.
 */
public class MyQuestionAdapter extends RecyclerView.Adapter implements RecyclerView.OnItemTouchListener {
    List<QAObj> mQAObjectList;
    Context mContext;

    public MyQuestionAdapter(Context context){
       this.mContext = context;
        mQAObjectList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_question, parent, false);
        RecyclerView.ViewHolder vh = new MyQuestionViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyQuestionViewHolder quesHolder = (MyQuestionViewHolder) holder;
        quesHolder.populateData(mQAObjectList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mQAObjectList.size();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public void setmQAObjectList(List<QAObj> qaObjectList){
        this.mQAObjectList = qaObjectList;
    }


}
