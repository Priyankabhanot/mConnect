package com.example.priyanka.connect;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by priyanka on 1/9/16.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    abstract public void populateData(Object data, int position);

}
