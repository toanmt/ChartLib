package com.toanmt.mpchart.custom;

import com.github.toanmt.mpcharts.data.Entry;
import com.github.toanmt.mpcharts.formatter.IValueFormatter;
import com.github.toanmt.mpcharts.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class MyValueFormatter implements IValueFormatter
{

    private final DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return mFormat.format(value) + " $";
    }
}
