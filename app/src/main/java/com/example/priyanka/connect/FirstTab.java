package com.example.priyanka.connect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by priyanka on 31/8/16.
 */
public class FirstTab extends Fragment {
    @Bind(R.id.asked_ques_rv) RecyclerView mRecyclerView;
   // @Bind(R.id.askB)
    private Context mContext;
    private List<QAObj> mQaObjectList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        initView();
        return view;
    }

    void initView(){
        initList();
        MyQuestionAdapter myQuestionAdapter = new MyQuestionAdapter(getActivity());
        myQuestionAdapter.setmQAObjectList(mQaObjectList);
        mRecyclerView.setAdapter(myQuestionAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    void initList(){
        mQaObjectList = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            if(i % 3 == 0){
                mQaObjectList.add(new QAObj("What is my name?", "Your name is XYZ",
                        1, "2 hours ago", true
                ));
            }else {
                mQaObjectList.add(new QAObj("What is his name?", "His name is ABC",
                        1, "2 hours ago", false));

            }
        }
    }
}
