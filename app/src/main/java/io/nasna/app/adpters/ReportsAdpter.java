package io.nasna.app.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.nasna.app.R;
import io.nasna.app.fonts.FontTextView;

public class ReportsAdpter extends RecyclerView.Adapter<ReportsAdpter.Holder> {

    JSONArray data = new JSONArray();
    Context tearegtActvity;
    int dataSetingFlag;

    public ReportsAdpter(Context tearegtActvity, JSONArray data, int dataSetingFlag) {
        this.data = data;
        this.dataSetingFlag = dataSetingFlag;
        this.tearegtActvity = tearegtActvity;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_report_row, null);
        ReportsAdpter.Holder holder = new Holder(v);
        return holder;

    }

    public void update(JSONArray dataList) {
        this.data = dataList;
        this.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        try {

            JSONObject reportData = data.getJSONObject(position);

            Toast.makeText(tearegtActvity, " thr length  of the array : "+data.length(), Toast.LENGTH_SHORT).show();

            // flags when=>1(Incoming), when=>2(Produacts_sutus), when=>3 (startigy) when=>4 (Soothing)

            switch (dataSetingFlag) {
                case 1:

                    holder.price.setText(reportData.getString("price"));


                    break;
                case 2:
                    if (reportData.getString("status_type") == "1") ;
                {
                    holder.proudact_stauts.setText("تالف");
                }

                break;

                case 3:

                    holder.proudactName.setText("اسم اﻻستراتبجة"+reportData.getString("strategy_name"));
                   // holder.profeit_percent.setText(reportData.getString("profit_percent"));

                    break;

                case 4:

                    holder.total.setText(reportData.getString("storage_space"));
//                    holder.discraption.setText(reportData.getString("discarption"));


                    break;

                case 5:
                    break;

            }
        } catch (JSONException e) {
            Toast.makeText(tearegtActvity, ""+e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    public class Holder extends RecyclerView.ViewHolder {
        FontTextView proudactName, proudact_stauts, price, starttgiy, discraption, profeit_percent, proudact_icmonig, proudact_outComing, total;

        public Holder(View itemView) {
            super(itemView);
            proudactName = (FontTextView) itemView.findViewById(R.id.prodactName);
            profeit_percent = (FontTextView) itemView.findViewById(R.id.profet_percent);
            proudact_icmonig = (FontTextView) itemView.findViewById(R.id.discrption);
            proudact_stauts = (FontTextView) itemView.findViewById(R.id.proudact_sutues);
            price=(FontTextView)itemView.findViewById(R.id.date);
            total = (FontTextView) itemView.findViewById(R.id.total);


        }
    }
}
