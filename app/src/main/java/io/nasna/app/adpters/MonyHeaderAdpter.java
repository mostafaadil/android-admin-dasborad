package io.nasna.app.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import io.nasna.app.R;

public class MonyHeaderAdpter extends RecyclerView.Adapter<MonyHeaderAdpter.HeaderHolder> {
      Context context;
      ArrayList list;
    public  MonyHeaderAdpter(Context context,ArrayList list){
        this.context=context;
        this.list=list;
    }
    @Override
    public HeaderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_account_mony_row, null);
        HeaderHolder headerHolder = new HeaderHolder(v);
        return headerHolder;
    }

    @Override
    public void onBindViewHolder(HeaderHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }
}
