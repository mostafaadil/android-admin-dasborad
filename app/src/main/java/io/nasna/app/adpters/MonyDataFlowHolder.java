package io.nasna.app.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.nasna.app.R;

public class MonyDataFlowHolder extends RecyclerView.Adapter<MonyDataFlowHolder.Holder> {
    Context actvity;
    ArrayList data;
    int flag;
    public  MonyDataFlowHolder(Context actvity,ArrayList data,int flag){
        this.actvity=actvity;
        this.flag=flag;
        this.data=data;
    }
    @Override
    public MonyDataFlowHolder.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ipin_input, null);

        MonyDataFlowHolder.Holder headerHolder = new Holder(v);
        return headerHolder;    }

    @Override
    public void onBindViewHolder(MonyDataFlowHolder.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
