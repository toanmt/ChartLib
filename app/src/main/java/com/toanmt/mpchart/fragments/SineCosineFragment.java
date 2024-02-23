package com.toanmt.mpchart.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.toanmt.mpcharts.charts.LineChart;
import com.github.toanmt.mpcharts.components.Legend;
import com.github.toanmt.mpcharts.components.XAxis;
import com.github.toanmt.mpcharts.components.YAxis;
import com.github.toanmt.mpcharts.data.Entry;
import com.github.toanmt.mpcharts.data.LineData;
import com.github.toanmt.mpcharts.data.LineDataSet;
import com.github.toanmt.mpcharts.interfaces.datasets.ILineDataSet;
import com.toanmt.mpchart.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SineCosineFragment extends SimpleFragment {

    @NonNull
    public static Fragment newInstance() {
        return new SineCosineFragment();
    }

    @SuppressWarnings("FieldCanBeLocal")
    private LineChart chart;

    float maxValue = 10;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_simple_line, container, false);
        initChart(v);
        //set data
        setChartDataDefault();
        //check Data
        checkChartData();
        chart.invalidate();

        return v;
    }

    private void initChart(View v) {
        chart = v.findViewById(R.id.lineChart1);
        chart.getDescription().setEnabled(false);
        chart.setTouchEnabled(false);
        chart.setDragEnabled(false);
        chart.setScaleEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        chart.animateX(3000);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        Legend l = chart.getLegend();
        l.setTypeface(tf);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setAxisMinimum(0);
        chart.getAxisRight().setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(false);
        leftAxis.setAxisMaximum(maxValue);
    }

    private void checkChartData() {
        int randomNumber = getRandomNumber();
        setData((float) randomNumber);
    }

    private static int getRandomNumber() {
        return new Random().nextInt(1000);
    }

    private void setChartDataDefault() {
        LineDataSet ds1 = new LineDataSet(new ArrayList<>(), "Sine function");
        ds1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        ds1.setLineWidth(2f);
        ds1.setDrawCircles(false);
        ds1.setColor(Color.parseColor("#06ACFF"));
        ArrayList<ILineDataSet> sets = new ArrayList<>();
        sets.add(ds1);
        LineData lineData = new LineData(sets);
        chart.setData(lineData);
    }

    private void setData(Float data) {
        Log.d("lkflgklf", "data: " + data);
        Log.d("lkflgklf", "maxValue: " + maxValue);
        if (data > maxValue) {
            chart.getAxisLeft().setAxisMaximum(maxValue + 10);
            maxValue = data;
        }
        Log.d("lkflgklf", "AxisMaximum: " + chart.getAxisLeft().getAxisMaximum());
        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            List<Entry> values = new ArrayList<>(lineDataSet.getEntries());
            Entry entry = new Entry(values.size() * 10, data);
            Log.d("lkflgklf", "data: " + data);
            values.add(entry);
            lineDataSet.setEntries(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            setChartDataDefault();
            setData(data);
        }
        Log.e("lkflgklf", "===================");
    }
}
