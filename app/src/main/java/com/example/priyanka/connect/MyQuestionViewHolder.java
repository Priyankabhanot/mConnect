package com.example.priyanka.connect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by priyanka on 1/9/16.
 */
public class MyQuestionViewHolder extends BaseViewHolder{
  //  @Bind(R.id.myQuestionLayout) MyQuestionCardView myQuestionCardView;
    View view;

    public MyQuestionViewHolder(View itemView) {
        super(itemView);
   //     ButterKnife.bind(itemView);
        view = itemView;

    }

    @Override
    public void populateData(Object data, int position) {
        if(view != null && view instanceof  MyQuestionCardView){
            ((MyQuestionCardView)view).populateData(data);
        }
    }

}
