package io.nasna.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.nasna.app.adpters.ReportsAdpter;
import io.nasna.app.models.DemoBase;

public class ReportsActvity extends DemoBase implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChart;
    Spinner reportPickUp;
    JSONArray array;
    ArrayList<String> arrayList;
    ReportsAdpter reportsAdpter;
    RecyclerView recyclerView;
    JSONArray data;

    JSONArray proudact_incoming;
    JSONArray proudact_sutus;
    JSONArray proudact_soothings;
    JSONArray proudact_startigie;
    JSONObject icnmoingContent;
    private List<PieEntry> NoOfEmp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout_reports);
        mChart = (PieChart) findViewById(R.id.pieChart);
        recyclerView = (RecyclerView) findViewById(R.id.dataRecycil);

        reportPickUp = (Spinner) findViewById(R.id.spinner);

        arrayList = new ArrayList<>();


        /** seamlitions  fo Json arrays **/
        String adminReportData = "[{\"proudact_incoming\":[{\"id\":1,\"price\":64,\"buy_date\":\"2020-08-07\",\"enterd_date\":\"2020-05-13\",\"product_id\":1,\"company_id\":1,\"quntity\":33,\"created_at\":\"2020-01-02 10:45:36\",\"updated_at\":\"2020-08-04 18:12:37\"},{\"id\":2,\"price\":21,\"buy_date\":\"2020-08-02\",\"enterd_date\":\"2020-08-02\",\"product_id\":1,\"company_id\":1,\"quntity\":33,\"created_at\":\"2020-08-02 10:48:41\",\"updated_at\":\"2020-08-04 18:12:37\"}]},{\"proudact_sutus\":[{\"id\":1,\"product_id\":1,\"status_type\":\"1\",\"created_at\":null,\"updated_at\":null}]},{\"proudact_soothings\":[{\"id\":1,\"product_id\":1,\"discarption\":\"dfgdfgdf\",\"storage_space\":1212,\"created_at\":\"2020-08-06 07:57:28\",\"updated_at\":\"2020-08-06 07:57:28\"}]},{\"proudact_startigie\":[{\"id\":1,\"strategy_name\":\"demo\",\"discraption\":\"jdskldsg\",\"profit_percent\":454,\"product_id\":1,\"created_at\":\"2020-08-06 08:42:08\",\"updated_at\":\"2020-08-06 08:42:08\"}]}]";

        String s = "[{\"id\":1,\"name\":\"mostafa\",\"enter_date\":\"2020-08-02\",\"classfcation_id\":1,\"created_at\":\"2020-08-02 10:42:22\",\"updated_at\":\"2020-08-02 10:42:22\"},{\"id\":2,\"name\":\"mostafa\",\"enter_date\":\"2020-08-02\",\"classfcation_id\":1,\"created_at\":\"2020-08-02 10:42:22\",\"updated_at\":\"2020-08-02 10:42:22\"}]";

        try {
            data = new JSONArray(adminReportData);

            proudact_incoming = data.getJSONObject(0).getJSONArray("proudact_incoming");
            proudact_sutus = data.getJSONObject(1).getJSONArray("proudact_sutus");
            proudact_soothings = data.getJSONObject(2).getJSONArray("proudact_soothings");
            proudact_startigie = data.getJSONObject(3).getJSONArray("proudact_startigie");

            reportsAdpter = new ReportsAdpter(this, proudact_incoming, 1);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        try {
            array = new JSONArray(s);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        //set the data of the elemint array in The produdacts spinners

        for (int i = 0; i < array.length(); i++) {

            try {
                JSONObject object = array.getJSONObject(i);
                arrayList.add(object.getString("name"));
            } catch (JSONException e) {
            }
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);

        reportPickUp.setAdapter(arrayAdapter);


        //getting The Id of Selected Proudct from Spinner

        reportPickUp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JSONObject object = array.getJSONObject(position);
                    ;


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        dataUp();
    }


    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void incomigReport(View view) {


        try {
            reportsAdpter = new ReportsAdpter(this, proudact_incoming, 1);

            recyclerView.setAdapter(reportsAdpter);

        } catch (Exception e) {

            Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();

        }


    }

    public void outComes(View view) {
    }

    public void sutues(View view) {


        try {
            reportsAdpter = new ReportsAdpter(this, proudact_sutus, 2);


            recyclerView.setAdapter(reportsAdpter);

        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();

        }


    }

    public void Soothings(View view) {

        try {
            reportsAdpter = new ReportsAdpter(this, proudact_soothings, 4);


            recyclerView.setAdapter(reportsAdpter);

        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();


        }


    }

    public void Strartigys(View view) {

        try {
            reportsAdpter = new ReportsAdpter(this, proudact_startigie, 3);


            recyclerView.setAdapter(reportsAdpter);

        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();


        }


    }


    void dataUp() {

        ArrayList<PieEntry> entries=new ArrayList<>();

        for (int i = 0; i < proudact_incoming.length(); i++) {
            try {
                JSONObject jsonObject = proudact_incoming.getJSONObject(i);

                entries.add(new PieEntry(Float.parseFloat(jsonObject.getString("price")),jsonObject.getInt("quntity")));


            } catch (JSONException e) {
                Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();
            }


        }

        PieDataSet set = new PieDataSet(entries, "gggg");
        PieData data = new PieData(set);

        set.setColors(ColorTemplate.COLORFUL_COLORS);
        mChart.animateXY(5000, 5000);
        mChart.setData(data);

    }

}
